package com.barbershop.api.controller.interfaces;

import com.barbershop.api.dto.workingDays.WorkingDaysDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IWorkingDaysController {

    ResponseEntity<WorkingDaysDTO> getById(Long id);
    ResponseEntity<List<WorkingDaysDTO>> getAll();
    ResponseEntity<WorkingDaysDTO> create(WorkingDaysDTO workingDays);
    ResponseEntity<WorkingDaysDTO> update(WorkingDaysDTO workingDays);
    ResponseEntity<WorkingDaysDTO> delete(Long id);

}
