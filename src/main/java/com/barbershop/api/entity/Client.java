package com.barbershop.api.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String phone;
    @Column(unique = true)
    private String email;
    @OneToMany(mappedBy = "client")
    private List<Schedule> schedules;
    @OneToMany(mappedBy = "client")
    private List<Payment> payments;

    public Client() {
    }

}
