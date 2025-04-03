package com.barbershop.api.controller.impl;

import com.barbershop.api.controller.interfaces.IScheduleController;
import com.barbershop.api.dto.schedules.ScheduleDTO;
import com.barbershop.api.dto.schedules.ScheduleMinDTO;
import com.barbershop.api.dto.schedules.ScheduleToCreateDTO;
import com.barbershop.api.service.interfaces.IScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/schedule")
@AllArgsConstructor
public class ScheduleController implements IScheduleController {

    private final IScheduleService service;

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<ScheduleDTO> getScheduleById(@PathVariable Long id) {
        var entity = service.findById(id);
        return ResponseEntity.ok(entity);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ScheduleMinDTO>> getAllSchedule() {
        var entities = service.findAll();
        return ResponseEntity.ok(entities);
    }

    @Override
    @GetMapping(value = "/date/{initial}-{end}")
    public ResponseEntity<List<ScheduleMinDTO>> getScheduleBetweenDates(@PathVariable String initial, @PathVariable String end) {
        var entities = service.findBetweenDates(initial, end);
        return ResponseEntity.ok(entities);
    }

    @Override
    @PostMapping
    public ResponseEntity<ScheduleDTO> createSchedule(@RequestBody ScheduleToCreateDTO scheduleToCreate) {
        var entity = service.insert(scheduleToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity)
                .toUri();
        return ResponseEntity.created(location).body(entity);
    }

    @Override
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteScheduleById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PutMapping
    public ResponseEntity<ScheduleDTO> updateSchedule(@RequestBody ScheduleToCreateDTO scheduleToUpdate) {
        var entity = service.update(scheduleToUpdate);
        return ResponseEntity.ok(entity);
    }
}
