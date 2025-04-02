package com.barbershop.api.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.barbershop.api.dto.clients.ClientDTO;
import com.barbershop.api.dto.clients.ClientMinDTO;
import com.barbershop.api.dto.clients.ClientPaymentDTO;
import com.barbershop.api.dto.clients.ClientScheduleDTO;
import com.barbershop.api.entity.Client;
import com.barbershop.api.mapper.ClientMapper;
import com.barbershop.api.repository.IClientRepository;
import com.barbershop.api.service.ReflectionUtils;
import com.barbershop.api.service.interfaces.IClientService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService implements IClientService {

    private final IClientRepository repository;

    @Override
    public ClientDTO findClientById(Long id) {
        var entity = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return ClientMapper.MAPPER.toDTO(entity);

    }

    @Override
    public List<ClientMinDTO> findAllClients() {
        List<Client> entities = repository.findAll();
        return entities.stream().map(ClientMapper.MAPPER::toMinDTO).collect(Collectors.toList());
    }

    @Override
    public ClientDTO insertClient(ClientDTO clientToCreate) {
        Client entity = new Client();
        List<String> attributes = ReflectionUtils.getFieldNames(Client.class);
        for (String attribute : attributes) {
            if (attribute.equalsIgnoreCase("id") && clientToCreate.getId() != null) {
                entity.setId(clientToCreate.getId());
            }
            ReflectionUtils.setFieldValue(entity, attribute,
                    ReflectionUtils.getFieldValue(clientToCreate, attribute));
        }
        var savedEntity = repository.save(entity);
        return ClientMapper.MAPPER.toDTO(savedEntity);
    }

    @Override
    public void deleteClientById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ClientScheduleDTO findAllClientSchedules(Long id) {
        Client entity = repository.findById(id).orElseThrow(NoSuchElementException::new);
        entity.getSchedules();
        return ClientMapper.MAPPER.tClientScheduleDTO(entity);
    }

    @Override
    public ClientPaymentDTO findAllClientPayments(Long id) {
        Client entity = repository.findById(id).orElseThrow(NoSuchElementException::new);
        entity.getPayments();
        return ClientMapper.MAPPER.toCPaymentDTO(entity);
    }
}
