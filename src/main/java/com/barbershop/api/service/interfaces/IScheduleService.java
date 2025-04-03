package com.barbershop.api.service.interfaces;

import java.util.List;

import com.barbershop.api.dto.schedules.ScheduleDTO;
import com.barbershop.api.dto.schedules.ScheduleMinDTO;
import com.barbershop.api.dto.schedules.ScheduleToCreateDTO;


public interface IScheduleService {

    ScheduleDTO findScheduleById(Long id);
    List<ScheduleMinDTO> findAllSchedule();
    List<ScheduleMinDTO> findScheduleBetweenDates(String initial, String end);
    ScheduleDTO insertSchedule(ScheduleToCreateDTO scheduleToCreate);
    void deleteScheduleById(Long id);

}
