package com.barbershop.api.controller.interfaces;

import java.util.List;

import com.barbershop.api.dto.BarberServiceDTO;
import com.barbershop.api.dto.BarberServiceMinDTO;
import com.barbershop.api.dto.BarberServiceSchedulesDTO;

public interface IBarberServiceController {

    BarberServiceDTO getBarberServiceById(Long id);
    List<BarberServiceMinDTO> getAllBarberService();
    List<BarberServiceSchedulesDTO> getBarberServiceSchedules(Long id);
    BarberServiceDTO createBarberService(BarberServiceDTO BarberServiceToCreate);
    void deleteBarberServiceById(Long id);
    BarberServiceDTO updateBarberService(BarberServiceDTO BarberServiceToUpdate);

}
