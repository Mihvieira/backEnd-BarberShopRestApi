package com.barbershop.api.dto.workingDays;

import jakarta.annotation.Nullable;

import java.time.OffsetTime;

public record WorkingDaysDTO(
        @Nullable Long id,
        String workingDay,
        OffsetTime openingHour,
        OffsetTime closingHour,
        OffsetTime startBreakTime,
        OffsetTime endBreakTime,
        @Nullable Long barberShopId
) {
}
