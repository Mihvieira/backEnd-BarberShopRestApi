package com.barbershop.api.dto.barberServices;

import java.time.Duration;

public record BarberServiceMinDTO(
    Long id,
    String name,
    Duration duration
) {

}
