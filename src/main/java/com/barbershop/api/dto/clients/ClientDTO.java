package com.barbershop.api.dto.clients;


import jakarta.annotation.Nullable;
import lombok.Data;

public record ClientDTO (
        @Nullable
        Long id,
        String name,
        String phone,
        String email
){
}
