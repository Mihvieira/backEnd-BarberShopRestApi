package com.barbershop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.api.entity.Client;

public interface IClientRepository extends JpaRepository<Client, Long>{

}
