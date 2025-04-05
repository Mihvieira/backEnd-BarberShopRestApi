package com.barbershop.api.controller.interfaces;

import java.time.OffsetDateTime;
import java.util.List;

import com.barbershop.api.dto.schedules.ScheduleDTO;
import com.barbershop.api.dto.schedules.ScheduleMinDTO;
import com.barbershop.api.dto.schedules.ScheduleToCreateDTO;
import org.springframework.http.ResponseEntity;

public interface IScheduleController {

    ResponseEntity<ScheduleDTO> getScheduleById(Long id);

    ResponseEntity<List<ScheduleMinDTO>> getAllSchedule();

    ResponseEntity<List<ScheduleMinDTO>> getScheduleBetweenDates(OffsetDateTime inicial, OffsetDateTime end);

    ResponseEntity<ScheduleDTO> createSchedule(ScheduleToCreateDTO scheduleToCreate);

    ResponseEntity<Void> deleteScheduleById(Long id);

    ResponseEntity<ScheduleDTO> updateSchedule(ScheduleToCreateDTO scheduleToUpdate);

}
