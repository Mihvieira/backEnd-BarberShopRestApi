package com.barbershop.api.dto;

import java.util.List;

public record BarberServiceSchedulesDTO(
    Long id,
    String name,
    List<ScheduleMinDTO> schedules
) {
}
