package com.barbershop.api.service.interfaces;

import java.util.List;

import com.barbershop.api.dto.clients.ClientDTO;
import com.barbershop.api.dto.clients.ClientMinDTO;
import com.barbershop.api.dto.clients.ClientPaymentDTO;
import com.barbershop.api.dto.clients.ClientScheduleDTO;

public interface IClientService {

    ClientDTO findById(Long id);

    List<ClientMinDTO> findAll();

    ClientDTO insert(ClientDTO clientToCreate);

    void delete(Long id);

    ClientScheduleDTO findSchedules(Long id);

    ClientPaymentDTO findPayments(Long id);

    ClientDTO update(ClientDTO clientToUpdate);

}
