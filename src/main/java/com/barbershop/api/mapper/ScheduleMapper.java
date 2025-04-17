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

    @Mapping(target = "startTime", expression = "java(calcStartTime(schedule.getDate()))")
    @Mapping(target = "endTime", expression = "java(calcEndTime(" +
            "schedule.getDate(), " +
            "schedule.getBarberService().getDuration())" +
            ")"
    )
    ScheduleDTO toDTO(Schedule schedule);

    @Mapping(target = "clientName", source = "client.name")
    ScheduleMinDTO toMinDTO(Schedule schedule);

    @Mapping(target = "client.id", source = "clientId")
    @Mapping(target = "barberService.id", source = "barberServiceId")
    Schedule toEntity(ScheduleToCreateDTO scheduleToCreateDTO);

    default String calcStartTime(OffsetDateTime date) {
        return date != null ? date.getHour() + ":" + date.getMinute() : null;
    }

    default String calcEndTime(OffsetDateTime date, OffsetTime duration) {
        if (date != null && duration != null) {
            OffsetDateTime endTime = date.plusHours(duration.getHour()).plusMinutes(duration.getMinute());
            return endTime.getHour() + ":" + endTime.getMinute();
        }
        return null;
    }

}
