package com.barbershop.api.entity;

import com.barbershop.api.entity.utils.WorkingDays;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name= "barber_shop")
@Data
@AllArgsConstructor
public class BarberShop {

    private Long id;
    private String name;
    private String address;
    @Embedded
    private WorkingDays workingDays;

    public BarberShop() {
    }
    

}
