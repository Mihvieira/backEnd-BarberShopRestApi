package com.barbershop.api.dto.schedules;

import java.time.OffsetDateTime;

public record ScheduleMinDTO(
        Long id,
        String clientName,
        OffsetDateTime date,
        String status
) {
}
