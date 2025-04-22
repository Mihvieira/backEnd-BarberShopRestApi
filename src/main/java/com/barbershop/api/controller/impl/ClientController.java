package com.barbershop.api.controller.impl;

import com.barbershop.api.controller.interfaces.IClientController;
import com.barbershop.api.dto.clients.ClientDTO;
import com.barbershop.api.dto.clients.ClientMinDTO;
import com.barbershop.api.dto.clients.ClientPaymentDTO;
import com.barbershop.api.dto.clients.ClientScheduleDTO;
import com.barbershop.api.service.interfaces.IClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController implements IClientController {

    private final IClientService service;

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        var entity = service.findById(id);
        return ResponseEntity.ok(entity);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ClientMinDTO>> getAllClients() {
        var entities = service.findAll();
        return ResponseEntity.ok(entities);
    }

    @Override
    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientToCreate) {
        var entity = service.insert(clientToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity)
                .toUri();
        return ResponseEntity.created(location).body(entity);
    }

    @Override
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteClientById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @Override
    @PutMapping
    public ResponseEntity<ClientDTO> updateClient(@RequestBody ClientDTO clientToUpdate) {
        var entity = service.update(clientToUpdate);
        return ResponseEntity.ok(entity);
    }

    @Override
    @GetMapping(value = "/schedules/{id}")
    public ResponseEntity<ClientScheduleDTO> getAllClientSchedules(@PathVariable Long id) {
        var schedules = service.findSchedules(id);
        return ResponseEntity.ok(schedules);
    }

    @Override
    @GetMapping(value = "/payments/{id}")
    public ResponseEntity<ClientPaymentDTO> getAllClientPayments(@PathVariable Long id) {
        var payments = service.findPayments(id);
        return ResponseEntity.ok(payments);
    }
}
