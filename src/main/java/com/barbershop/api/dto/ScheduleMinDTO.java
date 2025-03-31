package com.barbershop.api.dto;

import java.time.OffsetDateTime;

public record ScheduleMinDTO(
    Long id,
    OffsetDateTime date
) {
}
