package com.barbershop.api.dto;

import java.util.List;

import com.barbershop.api.entity.Schedule;

public record ClientScheduleDTO(
    Long id,
    String name,
    List<Schedule> schedules
) {

}
