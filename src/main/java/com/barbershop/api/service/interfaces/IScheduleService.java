package com.barbershop.api.service.interfaces;

import java.time.OffsetDateTime;
import java.util.List;

import com.barbershop.api.dto.schedules.ScheduleDTO;
import com.barbershop.api.dto.schedules.ScheduleMinDTO;
import com.barbershop.api.dto.schedules.ScheduleToCreateDTO;


public interface IScheduleService {

    ScheduleDTO findById(Long id);

    List<ScheduleMinDTO> findAll();

    List<ScheduleMinDTO> findBetweenDates(OffsetDateTime initial, OffsetDateTime end);

    ScheduleDTO insert(ScheduleToCreateDTO scheduleToCreate);

    void delete(Long id);

    ScheduleDTO update(ScheduleToCreateDTO scheduleToUpdate);

}
