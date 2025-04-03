package com.barbershop.api.service.impl;

import com.barbershop.api.dto.barberShop.BarberShopDTO;
import com.barbershop.api.entity.BarberShop;
import com.barbershop.api.mapper.BarberShopMapper;
import com.barbershop.api.repository.IBarberShopRepository;
import com.barbershop.api.service.interfaces.IBarberShopService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class BarberShopService implements IBarberShopService {

    private final IBarberShopRepository repository;

    @Override
    public BarberShopDTO findProfile() {
        var entity = repository.findById(1L).orElseThrow(NoSuchElementException::new);
        return BarberShopMapper.MAPPER.toDTO(entity);
    }

    @Override
    @Transactional
    public BarberShopDTO update(BarberShopDTO barberShopToUpdate) {
        BarberShop entity = BarberShopMapper.MAPPER.toEntity(barberShopToUpdate);
        var savedEntity = repository.save(entity);
        return BarberShopMapper.MAPPER.toDTO(savedEntity);
    }

}
