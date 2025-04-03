package com.barbershop.api.service.impl;

import com.barbershop.api.dto.workingDays.WorkingDaysDTO;
import com.barbershop.api.entity.WorkingDays;
import com.barbershop.api.mapper.WorkingDaysMapper;
import com.barbershop.api.repository.IWorkingDaysRepository;
import com.barbershop.api.service.interfaces.IWorkingDaysService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WorkingDaysService implements IWorkingDaysService {

    private final IWorkingDaysRepository repository;

    @Override
    public WorkingDaysDTO findById(Long id) {
        var entity = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return WorkingDaysMapper.MAPPER.toDTO(entity);
    }

    @Override
    public WorkingDaysDTO findByName(String name) {
        var entity = repository.findByWorkingDay(name).orElseThrow(NoSuchElementException::new);
        return WorkingDaysMapper.MAPPER.toDTO(entity);
    }

    @Override
    public List<WorkingDaysDTO> findAll() {
        List<WorkingDays> entities = repository.findAll();
        return entities.stream().map(WorkingDaysMapper.MAPPER::toDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public WorkingDaysDTO insert(WorkingDaysDTO dayToCreate) {
        WorkingDays entity = WorkingDaysMapper.MAPPER.toEntity(dayToCreate);
        var savedEntity = repository.save(entity);
        return WorkingDaysMapper.MAPPER.toDTO(savedEntity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public WorkingDaysDTO update(WorkingDaysDTO dayToUpdate) {
        if (dayToUpdate.id() == null) {
            throw new RuntimeException("Id must not be null");
        }
        return insert(dayToUpdate);
    }
}
