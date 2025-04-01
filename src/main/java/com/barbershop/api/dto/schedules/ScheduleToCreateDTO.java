package com.barbershop.api.dto.schedules;

import java.time.OffsetDateTime;

import com.barbershop.api.dto.barberServices.BarberServiceMinDTO;
import com.barbershop.api.dto.clients.ClientMinDTO;

public record ScheduleToCreateDTO(
    Long id,
    ClientMinDTO client,
    BarberServiceMinDTO barberService,
    OffsetDateTime date
) {

}
