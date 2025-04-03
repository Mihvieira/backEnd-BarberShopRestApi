package com.barbershop.api.dto.clients;

import java.util.List;

import com.barbershop.api.entity.Payment;

public record ClientPaymentDTO(
        Long id,
        String name,
        List<Payment> payments
) {
}
