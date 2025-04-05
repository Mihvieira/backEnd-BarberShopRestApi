package com.barbershop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.api.entity.BarberService;
import org.springframework.stereotype.Repository;

@Repository
public interface IBarberServiceRepository extends JpaRepository<BarberService, Long> {

}
