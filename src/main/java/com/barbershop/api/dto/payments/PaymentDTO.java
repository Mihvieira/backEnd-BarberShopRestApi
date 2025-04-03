package com.barbershop.api.dto.payments;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.barbershop.api.dto.clients.ClientMinDTO;

import jakarta.annotation.Nullable;

public record PaymentDTO (
        @Nullable
        Long id,
        String paymentMethod,
        OffsetDateTime date,
        BigDecimal amount,
        ClientMinDTO client
) {
}
