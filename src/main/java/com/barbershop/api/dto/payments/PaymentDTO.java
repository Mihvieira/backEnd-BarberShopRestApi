package com.barbershop.api.dto.payments;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.barbershop.api.dto.clients.ClientMinDTO;
import com.barbershop.api.entity.utils.PaymentMethods;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentDTO {

    private Long id;
    private PaymentMethods paymentMethod;
    private OffsetDateTime date;
    private BigDecimal amount;
    private ClientMinDTO client;

    public PaymentDTO() {
    }  

}
