package com.barbershop.api.entity;

import com.barbershop.api.entity.utils.WorkingDays;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name= "barber_shop")
@Data
@AllArgsConstructor
public class BarberShop {

    @Id
    private Long id;
    private String name;
    private String address;
    @Embedded
    private WorkingDays workingDays;

    public BarberShop() {
    }

}
