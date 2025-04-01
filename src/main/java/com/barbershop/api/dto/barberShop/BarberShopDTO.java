package com.barbershop.api.dto.barberShop;

import java.util.Set;

import com.barbershop.api.entity.utils.WorkingDays;

public record BarberShopDTO(
    Long id,
    String name,
    String address,
    Set<WorkingDays> workingDays
) {
} 

