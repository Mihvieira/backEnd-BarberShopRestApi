package com.barbershop.api.dto;

import java.time.Duration;

public record BarberServiceMinDTO(
    Long id,
    String name,
    Duration duration
) {

}
