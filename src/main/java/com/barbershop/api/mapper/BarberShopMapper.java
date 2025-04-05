package com.barbershop.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.barbershop.api.dto.barberShop.BarberShopDTO;
import com.barbershop.api.entity.BarberShop;

@Mapper(componentModel = "spring")
public interface BarberShopMapper {

    BarberShopMapper MAPPER = Mappers.getMapper(BarberShopMapper.class);

    @Mapping(source="workingDays", target="workingDays")
    BarberShopDTO toDTO(BarberShop barberShop);

    @Mapping(target = "id", ignore = true)
    @Mapping(source="workingDays", target="workingDays")
    BarberShop toEntity(BarberShopDTO barberShopDTO);

}
