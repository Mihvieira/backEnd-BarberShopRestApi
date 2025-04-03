package com.barbershop.api.repository;

import com.barbershop.api.entity.WorkingDays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IWorkingDaysRepository extends JpaRepository<WorkingDays, Long> {

    Optional<WorkingDays> findByWorkingDay(String workingDay);
}
