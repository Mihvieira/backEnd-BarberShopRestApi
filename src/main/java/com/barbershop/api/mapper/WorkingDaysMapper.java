package com.barbershop.api.mapper;

import com.barbershop.api.dto.workingDays.WorkingDaysDTO;
import com.barbershop.api.entity.WorkingDays;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = BarberShopMapper.class)
public interface WorkingDaysMapper {

    WorkingDaysMapper MAPPER = Mappers.getMapper(WorkingDaysMapper.class);

    @Mapping(target = "barberShopId", source = "barberShop.id")
    WorkingDaysDTO toDTO(WorkingDays workingDays);

    @Mapping(target = "barberShop.id", source = "barberShopId")
    WorkingDays toEntity(WorkingDaysDTO workingDays);
}
