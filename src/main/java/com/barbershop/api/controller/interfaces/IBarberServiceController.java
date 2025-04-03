package com.barbershop.api.controller.interfaces;

import java.util.List;

import com.barbershop.api.dto.barberServices.BarberServiceDTO;
import com.barbershop.api.dto.barberServices.BarberServiceMinDTO;
import com.barbershop.api.dto.barberServices.BarberServiceSchedulesDTO;
import org.springframework.http.ResponseEntity;

public interface IBarberServiceController {

    ResponseEntity<BarberServiceDTO> getBarberServiceById(Long id);
    ResponseEntity<List<BarberServiceMinDTO>> getAllBarberService();
    ResponseEntity<BarberServiceSchedulesDTO> getBarberServiceSchedules(Long id);
    ResponseEntity<BarberServiceDTO> createBarberService(BarberServiceDTO barberServiceToCreate);
    ResponseEntity<Void> deleteBarberServiceById(Long id);
    ResponseEntity<BarberServiceDTO> updateBarberService(BarberServiceDTO barberServiceToUpdate);

}
