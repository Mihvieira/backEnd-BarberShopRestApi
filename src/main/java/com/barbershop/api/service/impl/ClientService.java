package com.barbershop.api.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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

@AllArgsConstructor
public class ClientService implements IClientService {

    private final IClientRepository repository;
    private List<String> atributes = ReflectionUtils.getFieldNames(new Client().getClass());

    @Override
    public ClientDTO findClientById(Long id) {
        try {
            var entity = repository.findById(id).orElseThrow(NoSuchElementException::new);
            return ClientMapper.MAPPER.toDTO(entity);
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public List<ClientMinDTO> findAllClients() {
        List<Client> entities = repository.findAll();
        return entities.stream().map(x -> ClientMapper.MAPPER.toMinDTO(x)).collect(Collectors.toList());
    }

    @Override
    public ClientDTO insertClient(ClientDTO clientToCreate) {
        try {
            Client entity = new Client();
            for (String atribute : atributes) {
                if (atribute.equalsIgnoreCase("id") && clientToCreate.getId() != null) {
                    entity.setId(clientToCreate.getId());
                }
                ReflectionUtils.setFieldValue(entity, atribute,
                        ReflectionUtils.getFieldValue(clientToCreate, atribute));
            }
            var savedEntity = repository.save(entity);
            return ClientMapper.MAPPER.toDTO(savedEntity);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteClientById(Long id) {
        try {
            repository.deleteById(id);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(id + " : " + e.getMessage());
        }
    }

    @Override
    public ClientScheduleDTO findAllClientSchedules(Long id) {
        try {
            Client entity = repository.findById(id).orElseThrow(NoSuchElementException::new);
            entity.getSchedules();
            return ClientMapper.MAPPER.tClientScheduleDTO(entity);  
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }      
    }

    @Override
    public ClientPaymentDTO findAllClientPayments(Long id) {
        try {
            Client entity = repository.findById(id).orElseThrow(NoSuchElementException::new);
            entity.getPayments();
            return ClientMapper.MAPPER.toCPaymentDTO(entity);  
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }  
    }

}
