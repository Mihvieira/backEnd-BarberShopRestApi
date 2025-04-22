package com.barbershop.api.controller.impl;

import com.barbershop.api.controller.interfaces.IPaymentController;
import com.barbershop.api.dto.payments.PaymentDTO;
import com.barbershop.api.dto.payments.PaymentToCreateDTO;
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
    public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable Long id) {
        var entity = service.findById(id);
        return ResponseEntity.ok(entity);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<PaymentDTO>> getAllPayments() {
        var entities = service.findAll();
        return ResponseEntity.ok(entities);
    }

    @Override
    @PostMapping
    public ResponseEntity<PaymentDTO> createPayment(@RequestBody PaymentToCreateDTO paymentToCreate) {
        var entity = service.insert(paymentToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity)
                .toUri();
        return ResponseEntity.created(location).body(entity);
    }

    @Override
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deletePaymentById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @Override
    @PutMapping
    public ResponseEntity<PaymentDTO> updatePayment(@RequestBody PaymentToCreateDTO paymentToUpdate) {
        var entity = service.update(paymentToUpdate);
        return ResponseEntity.ok(entity);
    }
}
