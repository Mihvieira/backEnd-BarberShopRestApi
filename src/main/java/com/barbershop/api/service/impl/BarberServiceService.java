package com.barbershop.api.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.barbershop.api.dto.barberServices.BarberServiceDTO;
import com.barbershop.api.dto.barberServices.BarberServiceMinDTO;
import com.barbershop.api.dto.barberServices.BarberServiceSchedulesDTO;
import com.barbershop.api.entity.BarberService;
import com.barbershop.api.entity.Client;
import com.barbershop.api.mapper.BarberServiceMapper;
import com.barbershop.api.repository.IBarberServiceRepository;
import com.barbershop.api.service.ReflectionUtils;
import com.barbershop.api.service.interfaces.IBarberServiceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BarberServiceService implements IBarberServiceService{

    private final IBarberServiceRepository repository;

    @Override
    public BarberServiceDTO findBarberServiceById(Long id) {
        var entity = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return BarberServiceMapper.MAPPER.toDTO(entity);
    }

    @Override
    public List<BarberServiceMinDTO> findAllBarberService() {
        List<BarberService> entities = repository.findAll();
        return entities.stream().map(BarberServiceMapper.MAPPER::toMinDTO).collect(Collectors.toList());
    }

    @Override
    public BarberServiceSchedulesDTO findBarberServiceSchedules(Long id) {
        var entity = repository.findById(id).orElseThrow(NoSuchElementException::new);
        entity.getSchedules();
        return BarberServiceMapper.MAPPER.toServiceScheduleDTO(entity);
    }

    @Override
    public BarberServiceDTO insertBarberService(BarberServiceDTO barberServiceToCreate) {
        BarberService entity = new BarberService();
        List<String> attributes = ReflectionUtils.getFieldNames(BarberService.class);
        for (String attribute : attributes) {
            if (attribute.equalsIgnoreCase("id") && barberServiceToCreate.getId() != null) {
                entity.setId(barberServiceToCreate.getId());
            }
            ReflectionUtils.setFieldValue(entity, attribute,
                    ReflectionUtils.getFieldValue(barberServiceToCreate, attribute));
        }
        var savedEntity = repository.save(entity);
        return BarberServiceMapper.MAPPER.toDTO(savedEntity);
    }

    @Override
    public void deleteBarberServiceById(Long id) {
        repository.deleteById(id);
    }

}
