package com.barbershop.api.entity;

import java.time.OffsetDateTime;
import java.time.OffsetTime;

import com.barbershop.api.entity.utils.ScheduleStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(nullable = false, name = "barberService_id")
    private BarberService barberService;
    @Column(nullable = false, name="schedule_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone = "UTC")
    private OffsetDateTime date;
    @Enumerated(EnumType.STRING)
    private ScheduleStatus status;


    public Schedule() {
    }

    public String calcStartTime() {
        return this.date != null ? this.date.getHour() + ":" + this.date.getMinute() : null;
    }

    public String calcEndTime() {
        var duration = this.barberService.getDuration();
        if (this.date != null && duration != null) {
            OffsetDateTime endTime = this.date.plusHours(duration.getHour()).plusMinutes(duration.getMinute());
            return endTime.getHour() + ":" + endTime.getMinute();
        }
        return null;
    }

}
