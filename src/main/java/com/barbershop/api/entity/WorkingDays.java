package com.barbershop.api.entity;

import java.time.OffsetTime;

import com.barbershop.api.entity.utils.Days;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table(name = "working_days")
@AllArgsConstructor
public class WorkingDays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private Days workingDay;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss'Z'", timezone = "UTC")
    private OffsetTime openingHour;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss'Z'", timezone = "UTC")
    private OffsetTime closingHour;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss'Z'", timezone = "UTC")
    private OffsetTime startBreakTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss'Z'", timezone = "UTC")
    private OffsetTime endBreakTime;
    @JsonIgnore
    @ManyToOne
    private BarberShop barberShop;

    public WorkingDays() {
    }
}
