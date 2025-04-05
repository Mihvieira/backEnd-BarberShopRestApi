package com.barbershop.api.dto.barberServices;

import java.time.Duration;
import java.time.OffsetTime;

public record BarberServiceMinDTO(
        Long id,
        String name,
        OffsetTime duration
) {

}
