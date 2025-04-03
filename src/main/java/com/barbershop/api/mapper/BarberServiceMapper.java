package com.barbershop.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.barbershop.api.dto.barberServices.BarberServiceDTO;
import com.barbershop.api.dto.barberServices.BarberServiceMinDTO;
import com.barbershop.api.dto.barberServices.BarberServiceSchedulesDTO;
import com.barbershop.api.entity.BarberService;

@Mapper(componentModel = "spring")
public interface BarberServiceMapper {

    BarberServiceMapper MAPPER = Mappers.getMapper(BarberServiceMapper.class);

    BarberServiceDTO toDTO(BarberService barberService);

    @Mapping(target = "schedules", ignore = true)
    BarberService toEntity(BarberServiceDTO barberServiceDTO);

    BarberServiceMinDTO toMinDTO(BarberService barberservice);

    BarberServiceSchedulesDTO toServiceScheduleDTO(BarberService barberservice);

}
