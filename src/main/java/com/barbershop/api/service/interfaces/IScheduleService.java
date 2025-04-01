package com.barbershop.api.service.interfaces;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.List;

import com.barbershop.api.dto.schedules.ScheduleDTO;
import com.barbershop.api.dto.schedules.ScheduleMinDTO;
import com.barbershop.api.dto.schedules.ScheduleToCreateDTO;


public interface IScheduleService {

    ScheduleDTO findScheduleById(Long id);
    List<ScheduleMinDTO> findAllSchedule();
    List<ScheduleMinDTO> findScheduleBeteweenDates(String initial, String end);
    ScheduleDTO insertSchedule(ScheduleToCreateDTO ScheduleToCreate);
    void deleteScheduleById(Long id);
    ScheduleDTO updateSchedule(ScheduleDTO ScheduleToUpdate);
    String calcEndTime(OffsetDateTime date, Duration duration);

}
