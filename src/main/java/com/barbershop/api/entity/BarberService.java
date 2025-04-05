package com.barbershop.api.entity;

import java.math.BigDecimal;
import java.time.OffsetTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Entity
@Table(name = "barber_service")
public class BarberService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss'Z'", timezone = "UTC")
    private OffsetTime duration;
    @Column(nullable = false)
    private BigDecimal price;
    private String note;
    @OneToMany(mappedBy = "barberService")
    private List<Schedule> schedules;

    public BarberService() {
    }

}
