package com.barbershop.api.dto.payments;

import jakarta.annotation.Nullable;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record PaymentToCreateDTO(
        @Nullable
        Long id,
        String paymentMethod,
        OffsetDateTime date,
        BigDecimal amount,
        Long clientId
) {
}
