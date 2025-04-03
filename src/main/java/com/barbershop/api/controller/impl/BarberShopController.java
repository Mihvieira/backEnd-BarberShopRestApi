package com.barbershop.api.controller.impl;

import com.barbershop.api.controller.interfaces.IBarberShopController;
import com.barbershop.api.dto.barberShop.BarberShopDTO;
import com.barbershop.api.service.interfaces.IBarberShopService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/barber_shop")
public class BarberShopController implements IBarberShopController {

    private final IBarberShopService service;

    @Override
    @GetMapping
    public ResponseEntity<BarberShopDTO> getProfile() {
        var entity = service.findProfile();
        return ResponseEntity.ok(entity);
    }

    @Override
    @PutMapping
    public ResponseEntity<BarberShopDTO> updaBarberShop(@RequestBody BarberShopDTO barberShop) {
        var entity = service.updaBarberShop(barberShop);
        return ResponseEntity.ok(entity);
    }
}
