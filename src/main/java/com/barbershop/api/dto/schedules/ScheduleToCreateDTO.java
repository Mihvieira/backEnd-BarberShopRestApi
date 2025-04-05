package com.barbershop.api.dto.schedules;

import jakarta.annotation.Nullable;

import java.time.OffsetDateTime;

public record ScheduleToCreateDTO(
        @Nullable Long id,
        Long clientId,
        Long barberServiceId,
        OffsetDateTime date,
        @Nullable String status
) {

}
