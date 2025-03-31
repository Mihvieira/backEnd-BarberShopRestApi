package com.barbershop.api.dto;


import lombok.Data;

@Data
public class ClientDTO{

    private Long id;
    private String name;
    private String phone;
    private String email;
    
    public ClientDTO() {
    }

    public ClientDTO(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    

}
