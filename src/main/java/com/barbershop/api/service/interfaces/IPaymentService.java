package com.barbershop.api.service.interfaces;

import java.util.List;

import com.barbershop.api.dto.payments.PaymentDTO;

public interface IPaymentService {

    PaymentDTO findById(Long id);

    List<PaymentDTO> findAll();

    PaymentDTO insert(PaymentDTO paymentToCreate);

    void delete(Long id);

    PaymentDTO update(PaymentDTO paymentToUpdate);

}
