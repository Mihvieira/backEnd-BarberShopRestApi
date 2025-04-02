package com.barbershop.api.service.impl;

import com.barbershop.api.dto.barberShop.BarberShopDTO;
import com.barbershop.api.entity.BarberShop;
import com.barbershop.api.mapper.BarberShopMapper;
import com.barbershop.api.repository.IBarberShopRepository;
import com.barbershop.api.service.ReflectionUtils;
import com.barbershop.api.service.interfaces.IBarberShopService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class BarberShopService implements IBarberShopService{

    private final IBarberShopRepository repository;

    @Override
    public BarberShopDTO findProfile() {
        var entity = repository.findById(1L).orElseThrow(NoSuchElementException::new);
        return BarberShopMapper.MAPPER.toDTO(entity);
    }

    @Override
    public BarberShopDTO updaBarberShop(BarberShopDTO barberShopToUpdate) {
        BarberShop entity = new BarberShop();
        List<String> attributes = ReflectionUtils.getFieldNames(BarberShop.class);
        for (String attribute : attributes) {
            if (attribute.equalsIgnoreCase("id") && barberShopToUpdate.id() == null) {
                throw new RuntimeException("Id must not be null");
            }
            ReflectionUtils.setFieldValue(entity, attribute,
                    ReflectionUtils.getFieldValue(barberShopToUpdate, attribute));
        }
        var savedEntity = repository.save(entity);
        return BarberShopMapper.MAPPER.toDTO(savedEntity);
    }

}
