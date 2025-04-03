package com.barbershop.api.dto.schedules;

import java.time.OffsetDateTime;

public record ScheduleToCreateDTO(
    Long id,
    String clientId,
    String barberServiceId,
    OffsetDateTime date
) {

}
