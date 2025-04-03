package com.barbershop.api.service.interfaces;

import com.barbershop.api.dto.workingDays.WorkingDaysDTO;

import java.util.List;

public interface IWorkingDaysService {

    WorkingDaysDTO findById(Long id);

    WorkingDaysDTO findByName(String name);

    List<WorkingDaysDTO> findAll();

    WorkingDaysDTO insert(WorkingDaysDTO dayToCreate);

    void delete(Long id);

    WorkingDaysDTO update(WorkingDaysDTO dayToUpdate) throws RuntimeException;

}
