package com.barbershop.api.entity;

import java.time.OffsetTime;

import com.barbershop.api.entity.utils.Days;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table(name = "working_days")
@AllArgsConstructor
public class WorkingDays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private Days workingDay;

    @Column(nullable = false)
    private OffsetTime openingHour;

    @Column(nullable = false)
    private OffsetTime closingHour;

    private OffsetTime startBreakTime;

    private OffsetTime endBreakTime;

    @ManyToOne
    private BarberShop barberShop;

    public WorkingDays() {
    }
}
