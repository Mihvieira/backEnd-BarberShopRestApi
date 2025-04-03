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
import com.barbershop.api.repository.IBarberServiceRepository;
import com.barbershop.api.repository.IClientRepository;
import com.barbershop.api.repository.IScheduleRepository;
import com.barbershop.api.service.interfaces.IClientService;
import com.barbershop.api.service.interfaces.IScheduleService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ScheduleService implements IScheduleService{

    private final IScheduleRepository repository;
    @Getter
    private final IClientRepository clientRepository;
    @Getter
    private final IBarberServiceRepository serviceRepository;

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
    public List<ScheduleMinDTO> findScheduleBetweenDates(String initial, String end) {
        List<Schedule> entities = repository.findByDates(initial, end);
        return entities.stream().map(ScheduleMapper.MAPPER::toMinDTO).collect(Collectors.toList());
    }

    @Override
    public ScheduleDTO insertSchedule(ScheduleToCreateDTO scheduleToCreate) {
        Schedule entity = ScheduleMapper.MAPPER.toEntity(scheduleToCreate);
        var savedEntity = repository.save(entity);
        return ScheduleMapper.MAPPER.toDTO(savedEntity);
    }

    @Override
    public void deleteScheduleById(Long id) {
        repository.deleteById(id);
    }

}
