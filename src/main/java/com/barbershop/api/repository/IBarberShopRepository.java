package com.barbershop.api.repository;

import com.barbershop.api.entity.BarberShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBarberShopRepository extends JpaRepository<BarberShop, Long> {
}
