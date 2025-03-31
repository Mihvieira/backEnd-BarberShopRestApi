package com.barbershop.api.entity.utils;

import java.time.OffsetTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
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


    public Days getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(Days workingDay) {
        this.workingDay = workingDay;
    }

    public OffsetTime getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(OffsetTime openingHour) {
        this.openingHour = openingHour;
    }

    public OffsetTime getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(OffsetTime closingHour) {
        this.closingHour = closingHour;
    }

    public OffsetTime getStartBreakTime() {
        return startBreakTime;
    }

    public void setStartBreakTime(OffsetTime startBreakTime) {
        this.startBreakTime = startBreakTime;
    }

    public OffsetTime getEndBreakTime() {
        return endBreakTime;
    }

    public void setEndBreakTime(OffsetTime endBreakTime) {
        this.endBreakTime = endBreakTime;
    }
}
