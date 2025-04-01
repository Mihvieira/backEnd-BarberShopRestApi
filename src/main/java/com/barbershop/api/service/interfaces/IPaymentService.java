package com.barbershop.api.service.interfaces;

import java.util.List;

import com.barbershop.api.dto.payments.PaymentDTO;

public interface IPaymentService {

    PaymentDTO findPaymentById(Long id);
    List<PaymentDTO> findAllPayments();
    PaymentDTO insertPayment(PaymentDTO paymentToCreate);
    void deletePaymentById(Long id);
    PaymentDTO updatePayment(PaymentDTO paymentToUpdate);

}
