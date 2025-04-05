package com.barbershop.api.dto.schedules;

import java.time.OffsetDateTime;

public record ScheduleMinDTO(
        Long id,
        OffsetDateTime date,
        String status
) {
}
