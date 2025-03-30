package com.barbershop.api.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "barber_shop")
public class BarberShop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "barberShop", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<WorkingDays> workingDays;
    @OneToMany(mappedBy = "barberShop", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BarberService> services; 
    @OneToMany(mappedBy = "barberShop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Client> clients;
    @OneToMany(mappedBy = "barberShop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;

}
