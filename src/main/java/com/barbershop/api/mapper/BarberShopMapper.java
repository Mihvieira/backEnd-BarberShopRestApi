package com.barbershop.api.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.barbershop.api.dto.barberShop.BarberShopDTO;
import com.barbershop.api.entity.BarberShop;
import com.barbershop.api.entity.WorkingDays;

@Mapper(componentModel = "spring")
public interface BarberShopMapper {

    BarberShopMapper MAPPER = Mappers.getMapper(BarberShopMapper.class);

    BarberShopDTO toDTO(BarberShop barberShop);

    @Mapping(target = "barberShop.id", ignore = true)
    BarberShop toEntity(BarberShopDTO barberShopDTO);

    default Set<WorkingDays> map(WorkingDays workingDays) {
        return workingDays != null ? Set.of(workingDays) : Set.of();
    }

    default WorkingDays map(Set<WorkingDays> workingDaysSet) {
        return workingDaysSet != null && !workingDaysSet.isEmpty() ? workingDaysSet.iterator().next() : null;
    }
}
