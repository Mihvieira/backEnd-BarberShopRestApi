package com.barbershop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.api.entity.utils.WorkingDays;

public interface IWorkingDaysRepository extends JpaRepository<WorkingDays, Long>{

}
