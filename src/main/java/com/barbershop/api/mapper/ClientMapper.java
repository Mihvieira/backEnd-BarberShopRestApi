package com.barbershop.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.barbershop.api.dto.clients.ClientDTO;
import com.barbershop.api.dto.clients.ClientMinDTO;
import com.barbershop.api.dto.clients.ClientPaymentDTO;
import com.barbershop.api.dto.clients.ClientScheduleDTO;
import com.barbershop.api.entity.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientMapper MAPPER = Mappers.getMapper(ClientMapper.class);

    ClientDTO toDTO(Client client);

    @Mapping(target = "schedules", ignore = true)
    @Mapping(target = "payments", ignore = true)
    Client toEntity(ClientDTO clientDTO);

    ClientMinDTO toMinDTO(Client client);

    ClientPaymentDTO toCPaymentDTO(Client client);

    ClientScheduleDTO tClientScheduleDTO(Client client);

}
