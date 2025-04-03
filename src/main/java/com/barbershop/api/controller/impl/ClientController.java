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
        var entity = service.findClientById(id);
        return ResponseEntity.ok(entity);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ClientMinDTO>> getAllClients() {
        var entities = service.findAllClients();
        return ResponseEntity.ok(entities);
    }

    @Override
    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientToCreate) {
        var entity = service.insertClient(clientToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity)
                .toUri();
        return ResponseEntity.created(location).body(entity);
    }

    @Override
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteClientById(@PathVariable Long id) {
        service.deleteClientById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PutMapping
    public ResponseEntity<ClientDTO> updateClient(@RequestBody ClientDTO clientToUpdate) {
        var entity = service.insertClient(clientToUpdate);
        return ResponseEntity.ok(entity);
    }

    @Override
    @GetMapping(value = "/schedules/{id}")
    public ResponseEntity<ClientScheduleDTO> getAllClientSchedules(@PathVariable Long id) {
        var schedules = service.findAllClientSchedules(id);
        return ResponseEntity.ok(schedules);
    }

    @Override
    @GetMapping(value = "/payments/{id}")
    public ResponseEntity<ClientPaymentDTO> getAllClientPayments(@PathVariable Long id) {
        var payments = service.findAllClientPayments(id);
        return ResponseEntity.ok(payments);
    }
}
