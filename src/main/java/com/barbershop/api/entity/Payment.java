package com.barbershop.api.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.barbershop.api.entity.utils.PaymentMethods;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethods paymentMethod;
    @Column(nullable = false, name="payment_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    private OffsetDateTime date;
    @Column(nullable = false)
    private BigDecimal amount;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;


    public Payment() {
    }

}
