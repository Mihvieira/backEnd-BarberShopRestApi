package com.barbershop.api.dto.barberServices;

import java.math.BigDecimal;
import java.time.Duration;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;


public record BarberServiceDTO (
        @Nullable
        Long id,
        String name,
        Duration duration,
        BigDecimal price,
        String note
){}
