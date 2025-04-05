package com.barbershop.api.dto.barberServices;

import java.math.BigDecimal;
import java.time.OffsetTime;

import jakarta.annotation.Nullable;


public record BarberServiceDTO (
        @Nullable
        Long id,
        String name,
        OffsetTime duration,
        BigDecimal price,
        String note
){}
