package com.barbershop.api.dto.barberServices;

import java.util.List;

import com.barbershop.api.dto.schedules.ScheduleMinDTO;

public record BarberServiceSchedulesDTO(
    Long id,
    String name,
    List<ScheduleMinDTO> schedules ){
}
