package com.barbershop.api.dto.clients;

import java.util.List;

import com.barbershop.api.dto.schedules.ScheduleMinDTO;

public record ClientScheduleDTO(
        Long id,
        String name,
        List<ScheduleMinDTO> schedules
) {

}
