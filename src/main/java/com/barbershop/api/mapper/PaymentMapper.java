package com.barbershop.api.mapper;

import com.barbershop.api.dto.payments.PaymentDTO;
import com.barbershop.api.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapper {

    PaymentMapper MAPPER = Mappers.getMapper(PaymentMapper.class);

    PaymentDTO toDTO(Payment payment);
    Payment toEntity(PaymentDTO paymentDTO);
}
