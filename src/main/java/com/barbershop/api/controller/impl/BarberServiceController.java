package com.barbershop.api.controller.impl;

import com.barbershop.api.controller.interfaces.IBarberServiceController;
import com.barbershop.api.dto.barberServices.BarberServiceDTO;
import com.barbershop.api.dto.barberServices.BarberServiceMinDTO;
import com.barbershop.api.dto.barberServices.BarberServiceSchedulesDTO;
import com.barbershop.api.service.interfaces.IBarberServiceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/barber_service")
@AllArgsConstructor
public class BarberServiceController implements IBarberServiceController {

    private final IBarberServiceService service;

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<BarberServiceDTO> getBarberServiceById(@PathVariable Long id) {
        var entity = service.findById(id);
        return ResponseEntity.ok(entity);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<BarberServiceMinDTO>> getAllBarberService() {
        var entities = service.findAll();
        return ResponseEntity.ok(entities);
    }

    @Override
    @GetMapping(value = "/schedules/{id}")
    public ResponseEntity<BarberServiceSchedulesDTO> getBarberServiceSchedules(@PathVariable Long id) {
        var schedules = service.findSchedules(id);
        return ResponseEntity.ok(schedules);
    }

    @Override
    @PostMapping
    public ResponseEntity<BarberServiceDTO> createBarberService(@RequestBody BarberServiceDTO barberServiceToCreate) {
        var entity = service.insert(barberServiceToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity)
                .toUri();
        return ResponseEntity.created(location).body(entity);
    }

    @Override
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteBarberServiceById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PutMapping
    public ResponseEntity<BarberServiceDTO> updateBarberService(@RequestBody BarberServiceDTO barberServiceToUpdate) {
        var entity = service.update(barberServiceToUpdate);
        return ResponseEntity.ok(entity);
    }
}
