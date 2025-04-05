package com.barbershop.api.controller.interfaces;

import java.util.List;

import com.barbershop.api.dto.payments.PaymentDTO;
import com.barbershop.api.dto.payments.PaymentToCreateDTO;
import org.springframework.http.ResponseEntity;

public interface IPaymentController {

    ResponseEntity<PaymentDTO> getPaymentById(Long id);

    ResponseEntity<List<PaymentDTO>> getAllPayments();

    ResponseEntity<PaymentDTO> createPayment(PaymentToCreateDTO paymentToCreate);

    ResponseEntity<Void> deletePaymentById(Long id);

    ResponseEntity<PaymentDTO> updatePayment(PaymentToCreateDTO paymentToUpdate);

}
