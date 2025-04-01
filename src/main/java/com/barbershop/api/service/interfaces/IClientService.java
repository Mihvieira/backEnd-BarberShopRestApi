package com.barbershop.api.service.interfaces;

import java.util.List;

import com.barbershop.api.dto.clients.ClientDTO;
import com.barbershop.api.dto.clients.ClientMinDTO;
import com.barbershop.api.dto.clients.ClientPaymentDTO;
import com.barbershop.api.dto.clients.ClientScheduleDTO;

public interface IClientService {

    ClientDTO findClientById(Long id);
    List<ClientMinDTO> findAllClients();
    ClientDTO insertClient(ClientDTO clientToCreate);
    void deleteClientById(Long id);
    ClientScheduleDTO findAllClientSchedules(Long id);
    ClientPaymentDTO findAllClientPayments(Long id);

}
