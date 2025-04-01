package com.barbershop.api.controller.interfaces;

import java.util.List;

import com.barbershop.api.dto.barberServices.BarberServiceDTO;
import com.barbershop.api.dto.barberServices.BarberServiceMinDTO;
import com.barbershop.api.dto.barberServices.BarberServiceSchedulesDTO;

public interface IBarberServiceController {

    BarberServiceDTO getBarberServiceById(Long id);
    List<BarberServiceMinDTO> getAllBarberService();
    List<BarberServiceSchedulesDTO> getBarberServiceSchedules(Long id);
    BarberServiceDTO createBarberService(BarberServiceDTO BarberServiceToCreate);
    void deleteBarberServiceById(Long id);
    BarberServiceDTO updateBarberService(BarberServiceDTO BarberServiceToUpdate);

}
