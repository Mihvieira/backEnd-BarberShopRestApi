package com.barbershop.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "barber_shop")
@Data
@AllArgsConstructor
public class BarberShop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "barberShop")
    private Set<WorkingDays> workingDays;

    public BarberShop() {
    }

}
