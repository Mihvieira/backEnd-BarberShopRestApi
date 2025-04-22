package com.barbershop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.barbershop.api.entity.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long>{

    @Modifying
    @Query("UPDATE Client c SET c.name = :name WHERE c.id = :id")
    int updateByName(@Param("name") String name, @Param("id") Long id);

    @Modifying
    @Query("UPDATE Client c SET c.email = :email WHERE c.id = :id")
    int updateByEmail(@Param("email") String email, @Param("id") Long id);

    @Modifying
    @Query("UPDATE Client c SET c.phone = :phone WHERE c.id = :id")
    int updateByPhone(@Param("phone") String phone, @Param("id") Long id);

}
