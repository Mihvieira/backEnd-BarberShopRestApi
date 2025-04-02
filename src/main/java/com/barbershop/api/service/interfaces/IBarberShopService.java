package com.barbershop.api.service.interfaces;

import com.barbershop.api.dto.barberShop.BarberShopDTO;
import com.barbershop.api.entity.BarberShop;

public interface IBarberShopService {

    BarberShopDTO findProfile();
    BarberShopDTO updaBarberShop(BarberShopDTO barberShopToUpdate);

}
