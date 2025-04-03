package com.barbershop.api.controller.interfaces;

import java.util.List;

import com.barbershop.api.dto.payments.PaymentDTO;
import org.springframework.http.ResponseEntity;

public interface IPaymentController {

    ResponseEntity<PaymentDTO> getPaymentById(Long id);

    ResponseEntity<List<PaymentDTO>> getAllPayments();

    ResponseEntity<PaymentDTO> createPayment(PaymentDTO paymentToCreate);

    ResponseEntity<Void> deletePaymentById(Long id);

    ResponseEntity<PaymentDTO> updatePayment(PaymentDTO paymentToUpdate);

}
