package com.barbershop.api.service.interfaces;

import java.util.List;

import com.barbershop.api.dto.payments.PaymentDTO;
import com.barbershop.api.dto.payments.PaymentToCreateDTO;

public interface IPaymentService {

    PaymentDTO findById(Long id);

    List<PaymentDTO> findAll();

    PaymentDTO insert(PaymentToCreateDTO paymentToCreate);

    void delete(Long id);

    PaymentDTO update(PaymentToCreateDTO paymentToUpdate);

}
