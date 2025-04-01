package com.barbershop.api.dto.schedules;

import java.time.OffsetDateTime;

import com.barbershop.api.dto.barberServices.BarberServiceMinDTO;
import com.barbershop.api.dto.clients.ClientMinDTO;

public record ScheduleDTO(
    Long id,
    ClientMinDTO client,
    BarberServiceMinDTO barberService,
    OffsetDateTime date,
    String startTime,
    String endTime,
    String status
) {
}