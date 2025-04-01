package com.barbershop.api.controller.interfaces;

import java.util.List;

import com.barbershop.api.dto.schedules.ScheduleDTO;
import com.barbershop.api.dto.schedules.ScheduleMinDTO;
import com.barbershop.api.dto.schedules.ScheduleToCreateDTO;

public interface IScheduleController {

    ScheduleDTO getScheduleById(Long id);
    List<ScheduleMinDTO> getAllSchedule();
    List<ScheduleMinDTO> getScheduleBeteweenDates(String initial, String end);
    ScheduleDTO createSchedule(ScheduleToCreateDTO ScheduleToCreate);
    void deleteScheduleById(Long id);
    ScheduleDTO updateSchedule(ScheduleDTO ScheduleToUpdate);

}
