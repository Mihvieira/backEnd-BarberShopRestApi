package com.barbershop.api.controller.interfaces;

import java.util.List;

import com.barbershop.api.dto.PaymentDTO;

public interface IPaymentController {

    PaymentDTO getPaymentById(Long id);
    List<PaymentDTO> getAllPayments();
    PaymentDTO createPayment(PaymentDTO paymentToCreate);
    void deletePaymentById(Long id);
    PaymentDTO updatePayment(PaymentDTO paymentToUpdate);

}
