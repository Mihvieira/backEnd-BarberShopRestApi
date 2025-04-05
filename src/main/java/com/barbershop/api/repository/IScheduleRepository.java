package com.barbershop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.api.entity.Schedule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface IScheduleRepository extends JpaRepository<Schedule, Long>{

    @Query("SELECT s FROM Schedule s WHERE s.date BETWEEN :initial AND :end")
    List<Schedule> findByDates(@Param("initial") OffsetDateTime initial, @Param("end") OffsetDateTime end);
}
