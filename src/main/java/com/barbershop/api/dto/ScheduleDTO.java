package com.barbershop.api.dto;

import java.time.OffsetDateTime;

import com.barbershop.api.entity.utils.AppointmentStatus;

public record ScheduleDTO(
    Long id,
    ClientMinDTO client,
    BarberServiceMinDTO barberService,
    OffsetDateTime date,
    OffsetDateTime startTime,
    OffsetDateTime endTime,
    AppointmentStatus status
) {
}