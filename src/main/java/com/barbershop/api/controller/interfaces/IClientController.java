package com.barbershop.api.controller.interfaces;

import java.util.List;

import com.barbershop.api.dto.clients.ClientDTO;
import com.barbershop.api.dto.clients.ClientMinDTO;
import com.barbershop.api.dto.clients.ClientPaymentDTO;
import com.barbershop.api.dto.clients.ClientScheduleDTO;
import org.springframework.http.ResponseEntity;

public interface IClientController {
    
    ResponseEntity<ClientDTO> getClientById(Long id);
    ResponseEntity<List<ClientMinDTO>> getAllClients();
    ResponseEntity<ClientDTO> createClient(ClientDTO clientToCreate);
    ResponseEntity<Void> deleteClientById(Long id);
    ResponseEntity<ClientDTO> updateClient(ClientDTO clientToUpdate);
    ResponseEntity<ClientScheduleDTO> getAllClientSchedules(Long id);
    ResponseEntity<ClientPaymentDTO> getAllClientPayments(Long id);

}
