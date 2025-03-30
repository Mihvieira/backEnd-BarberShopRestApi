package com.barbershop.api.entity;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "barber_service")
public class BarberService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private Long duration;
    @Column(nullable = false)
    private BigDecimal price;
    @OneToMany(mappedBy = "id.appointment", orphanRemoval = true)
    private List<Appointment> appointments;

    public void setDuration(Duration d){
        this.duration = d.toMinutes();
    }

}
