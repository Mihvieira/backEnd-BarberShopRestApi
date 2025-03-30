package com.barbershop.api.entity;

import java.time.OffsetTime;

import com.barbershop.api.entity.utils.Days;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "working_days")
public class WorkingDays {

    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private Days workingDay;

    @Column(nullable = false)
    private OffsetTime openingHour;

    @Column(nullable = false)
    private OffsetTime closingHour;

    @Column(nullable = true)
    private OffsetTime startBreakTime;

    @Column(nullable = true)
    private OffsetTime endBreakTime;

    @ManyToOne(optional = false)
    private BarberShop barberShop;
    
}
