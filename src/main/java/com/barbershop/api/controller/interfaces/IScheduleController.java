package com.barbershop.api.controller.interfaces;

import java.util.List;

import com.barbershop.api.dto.ScheduleDTO;
import com.barbershop.api.dto.ScheduleMinDTO;

public interface IScheduleController {

    ScheduleDTO getScheduleById(Long id);
    List<ScheduleMinDTO> getAllSchedule();
    List<ScheduleMinDTO> getScheduleBeteweenDates(String initial, String end);
    ScheduleDTO createSchedule(ScheduleDTO ScheduleToCreate);
    void deleteScheduleById(Long id);
    ScheduleDTO updateSchedule(ScheduleDTO ScheduleToUpdate);

}
