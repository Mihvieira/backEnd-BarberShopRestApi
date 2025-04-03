package com.barbershop.api.entity.utils;

import java.time.OffsetTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Embeddable
@Data
public class WorkingDays {

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private Days workingDay;

    @Column(nullable = false)
    private OffsetTime openingHour;

    @Column(nullable = false)
    private OffsetTime closingHour;

    @Column(nullable = true)
    private OffsetTime startBreakTime;

    @Column(nullable = true)
    private OffsetTime endBreakTime;

    public WorkingDays() {
    }


    public WorkingDays(Days workingDay, OffsetTime openingHour, OffsetTime closingHour, OffsetTime startBreakTime,
            OffsetTime endBreakTime) {
        this.workingDay = workingDay;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.startBreakTime = startBreakTime;
        this.endBreakTime = endBreakTime;
    }
}
