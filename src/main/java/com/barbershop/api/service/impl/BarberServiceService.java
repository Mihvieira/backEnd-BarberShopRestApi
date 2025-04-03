package com.barbershop.api.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.barbershop.api.dto.barberServices.BarberServiceDTO;
import com.barbershop.api.dto.barberServices.BarberServiceMinDTO;
import com.barbershop.api.dto.barberServices.BarberServiceSchedulesDTO;
import com.barbershop.api.entity.BarberService;
import com.barbershop.api.mapper.BarberServiceMapper;
import com.barbershop.api.repository.IBarberServiceRepository;
import com.barbershop.api.service.interfaces.IBarberServiceService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BarberServiceService implements IBarberServiceService {

    private final IBarberServiceRepository repository;

    @Override
    public BarberServiceDTO findById(Long id) {
        var entity = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return BarberServiceMapper.MAPPER.toDTO(entity);
    }

    @Override
    public List<BarberServiceMinDTO> findAll() {
        List<BarberService> entities = repository.findAll();
        return entities.stream().map(BarberServiceMapper.MAPPER::toMinDTO).collect(Collectors.toList());
    }

    @Override
    public BarberServiceSchedulesDTO findSchedules(Long id) {
        var entity = repository.findById(id).orElseThrow(NoSuchElementException::new);
        entity.getSchedules();
        return BarberServiceMapper.MAPPER.toServiceScheduleDTO(entity);
    }

    @Override
    @Transactional
    public BarberServiceDTO insert(BarberServiceDTO barberServiceToCreate) {
        BarberService entity = BarberServiceMapper.MAPPER.toEntity(barberServiceToCreate);
        var savedEntity = repository.save(entity);
        return BarberServiceMapper.MAPPER.toDTO(savedEntity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public BarberServiceDTO update(BarberServiceDTO barberServiceToUpdate) {
        if (barberServiceToUpdate.id() == null) {
            throw new RuntimeException("Id must not be null");
        }
        return insert(barberServiceToUpdate);
    }

}
