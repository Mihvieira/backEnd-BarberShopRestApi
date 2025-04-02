package com.barbershop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.api.entity.Schedule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IScheduleRepository extends JpaRepository<Schedule, Long>{

    @Query("SELECT s FROM Schedule s WHERE s.date BETWEEN :initial AND :end")
    List<Schedule> findByDates(@Param("initial") String initial, @Param("end") String end);
}
