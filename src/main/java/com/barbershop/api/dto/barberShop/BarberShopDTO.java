package com.barbershop.api.dto.barberShop;

import java.util.Set;

import com.barbershop.api.entity.WorkingDays;
import jakarta.annotation.Nullable;

public record BarberShopDTO(
        @Nullable
        String name,
        @Nullable
        String address,
        @Nullable
        Set<WorkingDays> workingDays
) {
} 

