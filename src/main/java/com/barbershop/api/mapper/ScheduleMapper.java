package com.barbershop.api.mapper;

import java.time.OffsetDateTime;
import java.time.OffsetTime;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.barbershop.api.dto.schedules.ScheduleDTO;
import com.barbershop.api.dto.schedules.ScheduleMinDTO;
import com.barbershop.api.dto.schedules.ScheduleToCreateDTO;
import com.barbershop.api.entity.Schedule;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {

    ScheduleMapper MAPPER = Mappers.getMapper(ScheduleMapper.class);

    @Mapping(target = "startTime", expression = "java(schedule.calcStartTime())")
    @Mapping(target = "endTime", expression = "java(schedule.calcEndTime())"
    )
    ScheduleDTO toDTO(Schedule schedule);

    @Mapping(target = "clientName", source = "client.name")
    ScheduleMinDTO toMinDTO(Schedule schedule);

    @Mapping(target = "client.id", source = "clientId")
    @Mapping(target = "barberService.id", source = "barberServiceId")
    Schedule toEntity(ScheduleToCreateDTO scheduleToCreateDTO);

}
