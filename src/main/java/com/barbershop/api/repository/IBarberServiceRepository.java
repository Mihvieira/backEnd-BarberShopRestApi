package com.barbershop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.api.entity.BarberService;

public interface IBarberServiceRepository extends JpaRepository<BarberService, Long>{

}
