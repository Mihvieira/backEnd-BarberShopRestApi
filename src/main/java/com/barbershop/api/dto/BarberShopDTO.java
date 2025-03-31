package com.barbershop.api.dto;

import java.util.List;
import java.util.Set;

import com.barbershop.api.entity.utils.WorkingDays;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BarberShopDTO {

    private String name;
    private String address;
    private Set<WorkingDays> workingDays;
    private Set<BarberServiceDTO> services;
    private List<ClientMinDTO> clients;


    public BarberShopDTO() {
    }

}
