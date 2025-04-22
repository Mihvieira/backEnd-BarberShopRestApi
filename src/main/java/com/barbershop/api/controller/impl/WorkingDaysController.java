package com.barbershop.api.controller.impl;

import com.barbershop.api.controller.interfaces.IWorkingDaysController;
import com.barbershop.api.dto.workingDays.WorkingDaysDTO;
import com.barbershop.api.service.interfaces.IWorkingDaysService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/working-days")
@AllArgsConstructor
public class WorkingDaysController implements IWorkingDaysController {

    private final IWorkingDaysService service;

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<WorkingDaysDTO> getById(@PathVariable Long id) {
        var entity = service.findById(id);
        return ResponseEntity.ok(entity);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<WorkingDaysDTO>> getAll() {
        var entities = service.findAll();
        return ResponseEntity.ok(entities);
    }

    @Override
    @PostMapping
    public ResponseEntity<WorkingDaysDTO> create(@RequestBody WorkingDaysDTO workingDays) {
        var entity = service.insert(workingDays);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity)
                .toUri();
        return ResponseEntity.created(location).body(entity);
    }

    @Override
    @PutMapping
    public ResponseEntity<WorkingDaysDTO> update(@RequestBody WorkingDaysDTO workingDays) {
        var entity = service.update(workingDays);
        return ResponseEntity.ok(entity);
    }

    @Override
    @DeleteMapping(value = "{id}")
    public ResponseEntity<WorkingDaysDTO> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
