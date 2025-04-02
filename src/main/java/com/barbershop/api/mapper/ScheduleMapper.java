package com.barbershop.api.mapper;

import java.time.OffsetDateTime;
import java.util.NoSuchElementException;
import com.barbershop.api.entity.BarberService;
import com.barbershop.api.entity.Client;
import com.barbershop.api.repository.IClientRepository;
import com.barbershop.api.repository.IBarberServiceRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import com.barbershop.api.dto.schedules.ScheduleDTO;
import com.barbershop.api.dto.schedules.ScheduleMinDTO;
import com.barbershop.api.dto.schedules.ScheduleToCreateDTO;
import com.barbershop.api.entity.Schedule;

@Mapper(componentModel = "spring", uses = {ClientMapper.class, BarberServiceMapper.class})
public interface ScheduleMapper {

    ScheduleMapper MAPPER = Mappers.getMapper(ScheduleMapper.class);

    @Mapping(target = "startTime", expression = "java(scheduleService.calcStartTime(schedule.getDate()))")
    @Mapping(target = "endTime", expression = "java(scheduleService.calcEndTime(schedule.getDate(), java.time.Duration.ofMinutes(schedule.getBarberService().getDuration())")
    ScheduleDTO toDTO(Schedule schedule);

    ScheduleMinDTO toMinDTO(Schedule schedule);

    @Mapping(target = "client", source = "clientId", qualifiedByName = "mapClient")
    @Mapping(target = "barberService", source = "barberServiceId", qualifiedByName = "mapBarberService")
    Schedule toEntity(ScheduleToCreateDTO scheduleToCreateDTO);

    @Named("mapClient")
    default Client mapClient(String clientId, IClientRepository clientRepository) {
        return clientRepository.findById(Long.valueOf(clientId)).orElseThrow(NoSuchElementException::new);
    }

    @Named("mapBarberService")
    default BarberService mapBarberService(String barberServiceId, IBarberServiceRepository barberServiceRepository) {
        return barberServiceRepository.findById(Long.valueOf(barberServiceId)).orElseThrow(NoSuchElementException::new);
    }


}
