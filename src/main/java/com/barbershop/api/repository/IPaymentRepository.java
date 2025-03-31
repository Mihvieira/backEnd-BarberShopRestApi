package com.barbershop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.api.entity.Payment;

public interface IPaymentRepository extends JpaRepository<Payment, Long>{

}
