package com.barbershop.api.dto.payments;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.barbershop.api.dto.clients.ClientMinDTO;

public record PaymentDTO (
        Long id,
        String paymentMethod,
        OffsetDateTime date,
        BigDecimal amount,
        ClientMinDTO client
        ) {
}
