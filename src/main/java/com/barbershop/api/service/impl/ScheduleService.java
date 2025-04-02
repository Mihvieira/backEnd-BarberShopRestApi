package com.barbershop.api.service.impl;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.barbershop.api.dto.schedules.ScheduleDTO;
import com.barbershop.api.dto.schedules.ScheduleMinDTO;
import com.barbershop.api.dto.schedules.ScheduleToCreateDTO;
import com.barbershop.api.entity.Schedule;
import com.barbershop.api.mapper.ScheduleMapper;
import com.barbershop.api.repository.IScheduleRepository;
import com.barbershop.api.service.ReflectionUtils;
import com.barbershop.api.service.interfaces.IScheduleService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ScheduleService implements IScheduleService{

    private final IScheduleRepository repository;

    @Override
    public ScheduleDTO findScheduleById(Long id) {
        var entity = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return ScheduleMapper.MAPPER.toDTO(entity);
    }

    @Override
    public List<ScheduleMinDTO> findAllSchedule() {
        List<Schedule> entities = repository.findAll();
        return entities.stream().map(ScheduleMapper.MAPPER::toMinDTO).collect(Collectors.toList());
    }

    @Override
    public List<ScheduleMinDTO> findScheduleBeteweenDates(String initial, String end) {
        List<Schedule> entities = repository.findByDates(initial, end);
        return entities.stream().map(ScheduleMapper.MAPPER::toMinDTO).collect(Collectors.toList());
    }

    @Override
    public ScheduleDTO insertSchedule(ScheduleToCreateDTO scheduleToCreate) {
        Schedule entity = new Schedule();
        List<String> attributes = ReflectionUtils.getFieldNames(Schedule.class);
        for (String attribute : attributes) {
            if (attribute.equalsIgnoreCase("id") && scheduleToCreate.id() != null) {
                entity.setId(scheduleToCreate.id());
            }
            ReflectionUtils.setFieldValue(entity, attribute,
                    ReflectionUtils.getFieldValue(scheduleToCreate, attribute));
        }
        var savedEntity = repository.save(entity);
        return ScheduleMapper.MAPPER.toDTO(savedEntity);
    }

    @Override
    public void deleteScheduleById(Long id) {
        repository.deleteById(id);
    }

    public String calcStartTime(OffsetDateTime date) {
        return date != null ? date.getHour() + ":"+ date.getMinute(): null;
    }

    public String calcEndTime(OffsetDateTime date, java.time.Duration duration) {
        if (date != null && duration != null) {
            OffsetDateTime endTime = date.plus(duration);
            return endTime.getHour() + ":" + endTime.getMinute();
        }
        return null;
    }

}
