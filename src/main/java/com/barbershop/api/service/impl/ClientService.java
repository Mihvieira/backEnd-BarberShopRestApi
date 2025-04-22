package com.barbershop.api.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.barbershop.api.controller.impl.ClientController;
import com.barbershop.api.dto.clients.ClientDTO;
import com.barbershop.api.dto.clients.ClientMinDTO;
import com.barbershop.api.dto.clients.ClientPaymentDTO;
import com.barbershop.api.dto.clients.ClientScheduleDTO;
import com.barbershop.api.entity.Client;
import com.barbershop.api.mapper.ClientMapper;
import com.barbershop.api.repository.IClientRepository;
import com.barbershop.api.service.interfaces.IClientService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService implements IClientService {

    private final IClientRepository repository;

    @Override
    public ClientDTO findById(Long id) {
        var entity = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return ClientMapper.MAPPER.toDTO(entity);

    }

    @Override
    public List<ClientMinDTO> findAll() {
        List<Client> entities = repository.findAll();
        return entities.stream().map(ClientMapper.MAPPER::toMinDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ClientDTO insert(ClientDTO clientToCreate) {
        Client entity = ClientMapper.MAPPER.toEntity(clientToCreate);
        var savedEntity = repository.save(entity);
        return ClientMapper.MAPPER.toDTO(savedEntity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ClientScheduleDTO findSchedules(Long id) {
        Client entity = repository.findById(id).orElseThrow(NoSuchElementException::new);
        entity.getSchedules();
        return ClientMapper.MAPPER.tClientScheduleDTO(entity);
    }

    @Override
    public ClientPaymentDTO findPayments(Long id) {
        Client entity = repository.findById(id).orElseThrow(NoSuchElementException::new);
        entity.getPayments();
        return ClientMapper.MAPPER.toCPaymentDTO(entity);
    }

    @Override
    @Transactional
    public ClientDTO update(ClientDTO clientToUpdate) {
        if (clientToUpdate.id() == null) {
            throw new RuntimeException("Id must not be null");
        } else{
            Client client = repository.findById(clientToUpdate.id())
            .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado."));
            if(client.getName().equalsIgnoreCase(clientToUpdate.name())){
                repository.updateByName(clientToUpdate.name(), client.getId());
                client.setName(clientToUpdate.name());
            }else if(client.getEmail().equalsIgnoreCase(clientToUpdate.email())){
                repository.updateByEmail(clientToUpdate.email(), client.getId());
                client.setEmail(clientToUpdate.email());
            } else if(client.getPhone().equalsIgnoreCase(clientToUpdate.phone())){
                repository.updateByPhone(clientToUpdate.phone(), client.getId());
                client.setPhone(clientToUpdate.phone());
            }
            return ClientMapper.MAPPER.toDTO(client);
        }    
    }
}
