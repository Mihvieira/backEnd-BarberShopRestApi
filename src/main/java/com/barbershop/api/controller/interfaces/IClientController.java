package com.barbershop.api.controller.interfaces;

import java.util.List;

import com.barbershop.api.dto.clients.ClientDTO;
import com.barbershop.api.dto.clients.ClientMinDTO;
import com.barbershop.api.dto.clients.ClientPaymentDTO;
import com.barbershop.api.dto.clients.ClientScheduleDTO;

public interface IClientController {
    
    ClientDTO getClientById(Long id);
    List<ClientMinDTO> getAllClients();
    ClientDTO createClient(ClientDTO clientToCreate);
    void deleteClientById(Long id);
    ClientDTO updateClient(ClientDTO clientToUpdate);
    ClientScheduleDTO getAllClientSchedules(Long id);
    ClientPaymentDTO getAllClientPayments(Long id);

}
