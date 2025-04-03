package com.barbershop.api.mapper;

import java.time.OffsetDateTime;
import java.util.NoSuchElementException;
import com.barbershop.api.entity.BarberService;
import com.barbershop.api.entity.Client;
import com.barbershop.api.service.impl.ScheduleService;
import org.hibernate.service.spi.InjectService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import com.barbershop.api.dto.schedules.ScheduleDTO;
import com.barbershop.api.dto.schedules.ScheduleMinDTO;
import com.barbershop.api.dto.schedules.ScheduleToCreateDTO;
import com.barbershop.api.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {ClientMapper.class, BarberServiceMapper.class})
public interface ScheduleMapper {


    ScheduleMapper MAPPER = Mappers.getMapper(ScheduleMapper.class);

    @Mapping(target = "startTime", expression = "java(calcStartTime(schedule.getDate()))")
    @Mapping(target = "endTime", expression = "java(calcEndTime(" +
            "schedule.getDate(), " +
            "schedule.getBarberService().getDuration())" +
            ")"
    )
    ScheduleDTO toDTO(Schedule schedule);

    ScheduleMinDTO toMinDTO(Schedule schedule);

    @Mapping(target = "client.id", source = "clientId")
    @Mapping(target = "barberService.id", source = "barberServiceId")
    @Mapping(target = "status", ignore = true)
    Schedule toEntity(ScheduleToCreateDTO scheduleToCreateDTO);

    @Mapping(target = "client", source = "clientId")
    default Client getClient(Long clientId) {
        var client = new Client();
        client.setId(clientId);
        return client;
    }

    @Named("mapBarberService")
    default BarberService mapBarberService(Long barberServiceId, @Context ScheduleService scheduleService) {
        return scheduleService.getServiceRepository().findById(barberServiceId).orElseThrow(NoSuchElementException::new);
    }

    public default String calcStartTime(OffsetDateTime date) {
        return date != null ? date.getHour() + ":"+ date.getMinute(): null;
    }

    public default String calcEndTime(OffsetDateTime date, java.time.Duration duration) {
        if (date != null && duration != null) {
            OffsetDateTime endTime = date.plus(duration);
            return endTime.getHour() + ":" + endTime.getMinute();
        }
        return null;
    }


}
