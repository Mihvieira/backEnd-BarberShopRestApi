package com.barbershop.api.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.barbershop.api.dto.payments.PaymentDTO;
import com.barbershop.api.dto.payments.PaymentToCreateDTO;
import com.barbershop.api.entity.Payment;
import com.barbershop.api.mapper.PaymentMapper;
import com.barbershop.api.repository.IPaymentRepository;
import com.barbershop.api.service.interfaces.IPaymentService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentService implements IPaymentService {

    private final IPaymentRepository repository;

    @Override
    public PaymentDTO findById(Long id) {
        var entity = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return PaymentMapper.MAPPER.toDTO(entity);
    }

    @Override
    public List<PaymentDTO> findAll() {
        List<Payment> entities = repository.findAll();
        return entities.stream().map(PaymentMapper.MAPPER::toDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PaymentDTO insert(PaymentToCreateDTO paymentToCreate) {
        Payment entity = PaymentMapper.MAPPER.toCreateEntity(paymentToCreate);
        var savedEntity = repository.save(entity);
        return PaymentMapper.MAPPER.toDTO(savedEntity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(id + " : " + e.getMessage());
        }
    }

    @Override
    public PaymentDTO update(PaymentToCreateDTO paymentToUpdate) {
        if (paymentToUpdate.id() == null) {
            throw new RuntimeException("Id must not be null");
        }
        return insert(paymentToUpdate);
    }

}
