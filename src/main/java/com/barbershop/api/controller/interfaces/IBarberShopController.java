package com.barbershop.api.controller.interfaces;

import com.barbershop.api.dto.barberShop.BarberShopDTO;
import org.springframework.http.ResponseEntity;

public interface IBarberShopController {

    ResponseEntity<BarberShopDTO> getProfile();
    ResponseEntity<BarberShopDTO> updaBarberShop(BarberShopDTO barberShop);

}
