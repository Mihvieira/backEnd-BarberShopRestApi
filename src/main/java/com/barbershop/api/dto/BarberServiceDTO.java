package com.barbershop.api.dto;

import java.math.BigDecimal;
import java.time.Duration;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BarberServiceDTO {

    private Long id;
    private String name;
    private Duration duration;
    private BigDecimal price;
    private String note;


    public BarberServiceDTO() {
    }


}
