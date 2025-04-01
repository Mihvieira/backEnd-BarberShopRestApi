package com.barbershop.api.mapper;

import java.time.OffsetDateTime;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.barbershop.api.dto.schedules.ScheduleDTO;
import com.barbershop.api.dto.schedules.ScheduleMinDTO;
import com.barbershop.api.dto.schedules.ScheduleToCreateDTO;
import com.barbershop.api.entity.Schedule;

@Mapper
public interface ScheduleMapper {

    ScheduleMapper mapper = Mappers.getMapper(ScheduleMapper.class);

    @Mapping(target = "startTime", expression = "java(mapStartTime(schedule.getDate()))")
    @Mapping(target = "endTime", ignore=true)
    ScheduleDTO toDTO(Schedule schedule);
    ScheduleMinDTO toMinDTO(Schedule schedule);
    @Mapping(target="client", ignore=true)
    @Mapping(target = "barberService", ignore = true)
    @Mapping(target = "status", ignore = true)
    Schedule toEntity(ScheduleToCreateDTO scheduleToCreateDTO);

    default String mapStartTime(OffsetDateTime date) {
        return date != null ? date.getHour() + ":"+ date.getMinute(): null;
    }

}
