package com.barbershop.api.service.impl;

import java.time.OffsetDateTime;
import java.util.List;

import com.barbershop.api.dto.schedules.ScheduleDTO;
import com.barbershop.api.dto.schedules.ScheduleMinDTO;
import com.barbershop.api.dto.schedules.ScheduleToCreateDTO;
import com.barbershop.api.service.interfaces.IScheduleService;

import ch.qos.logback.core.util.Duration;

public class ScheduleService implements IScheduleService{

    @Override
    public ScheduleDTO findScheduleById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findScheduleById'");
    }

    @Override
    public List<ScheduleMinDTO> findAllSchedule() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllSchedule'");
    }

    @Override
    public List<ScheduleMinDTO> findScheduleBeteweenDates(String initial, String end) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findScheduleBeteweenDates'");
    }

    @Override
    public ScheduleDTO insertSchedule(ScheduleToCreateDTO ScheduleToCreate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertSchedule'");
    }

    @Override
    public void deleteScheduleById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteScheduleById'");
    }

    @Override
    public ScheduleDTO updateSchedule(ScheduleDTO ScheduleToUpdate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSchedule'");
    }

    default String mapEndTime(Duration duration, OffsetDateTime date) {
        if (duration != null && date != null) {
            int totalMinutes = date.getHour() * 60 + date.getMinute() + (int) duration.getMilliseconds() / 60000;
            int hours = totalMinutes / 60;
            int minutes = totalMinutes % 60;
            return String.format("%02d:%02d", hours, minutes);
        }
    }

}
