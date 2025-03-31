package com.barbershop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.api.entity.Schedule;

public interface IScheduleRepository extends JpaRepository<Schedule, Long>{

}
