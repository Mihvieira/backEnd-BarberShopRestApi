package com.barbershop.api.controller.impl;

import com.barbershop.api.controller.interfaces.IPaymentController;
import com.barbershop.api.dto.payments.PaymentDTO;
import com.barbershop.api.service.interfaces.IPaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/payment")
public class PaymentController implements IPaymentController {

    private final IPaymentService service;

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<PaymentDTO> getPaymentById(Long id) {
        var entity = service.findPaymentById(id);
        return ResponseEntity.ok(entity);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<PaymentDTO>> getAllPayments() {
        var entities = service.findAllPayments();
        return ResponseEntity.ok(entities);
    }

    @Override
    @PostMapping
    public ResponseEntity<PaymentDTO> createPayment(PaymentDTO paymentToCreate) {
        var entity = service.insertPayment(paymentToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity)
                .toUri();
        return ResponseEntity.created(location).body(entity);
    }

    @Override
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deletePaymentById(Long id) {
        service.deletePaymentById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PutMapping
    public ResponseEntity<PaymentDTO> updatePayment(PaymentDTO paymentToUpdate) {
        var entity = service.insertPayment(paymentToUpdate);
        return ResponseEntity.ok(entity);
    }
}
