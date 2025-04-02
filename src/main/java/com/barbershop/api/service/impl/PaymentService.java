package com.barbershop.api.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.barbershop.api.dto.payments.PaymentDTO;
import com.barbershop.api.entity.Client;
import com.barbershop.api.entity.Payment;
import com.barbershop.api.mapper.ClientMapper;
import com.barbershop.api.mapper.PaymentMapper;
import com.barbershop.api.repository.IPaymentRepository;
import com.barbershop.api.service.ReflectionUtils;
import com.barbershop.api.service.interfaces.IPaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentService implements IPaymentService{

    private final IPaymentRepository repository;

    @Override
    public PaymentDTO findPaymentById(Long id) {
        var entity = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return PaymentMapper.MAPPER.toDTO(entity);
    }

    @Override
    public List<PaymentDTO> findAllPayments() {
        List<Payment> entities = repository.findAll();
        return entities.stream().map(PaymentMapper.MAPPER::toDTO).collect(Collectors.toList());
    }

    @Override
    public PaymentDTO insertPayment(PaymentDTO paymentToCreate) {
            Payment entity = new Payment();
            List<String> attributes = ReflectionUtils.getFieldNames(Payment.class);
        for (String attribute : attributes) {
                if (attribute.equalsIgnoreCase("id") && paymentToCreate.getId() != null) {
                    entity.setId(paymentToCreate.getId());
                }
                ReflectionUtils.setFieldValue(entity, attribute,
                        ReflectionUtils.getFieldValue(paymentToCreate, attribute));
            }
            var savedEntity = repository.save(entity);
            return PaymentMapper.MAPPER.toDTO(savedEntity);
    }

    @Override
    public void deletePaymentById(Long id) {
        try {
            repository.deleteById(id);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(id + " : " + e.getMessage());
        }
    }

}
