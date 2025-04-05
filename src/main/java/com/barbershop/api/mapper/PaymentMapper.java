package com.barbershop.api.mapper;

import com.barbershop.api.dto.payments.PaymentDTO;
import com.barbershop.api.dto.payments.PaymentToCreateDTO;
import com.barbershop.api.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentMapper MAPPER = Mappers.getMapper(PaymentMapper.class);

    PaymentDTO toDTO(Payment payment);

    @Mapping(target = "client.phone", ignore = true)
    @Mapping(target = "client.email", ignore = true)
    @Mapping(target = "client.schedules", ignore = true)
    @Mapping(target = "client.payments", ignore = true)
    Payment toEntity(PaymentDTO paymentDTO);

    @Mapping(target = "client.id", source = "clientId")
    Payment toCreateEntity(PaymentToCreateDTO payment);
}
