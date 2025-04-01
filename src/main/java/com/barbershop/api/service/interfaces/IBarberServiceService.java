package com.barbershop.api.service.interfaces;

import java.util.List;

import com.barbershop.api.dto.barberServices.BarberServiceDTO;
import com.barbershop.api.dto.barberServices.BarberServiceMinDTO;
import com.barbershop.api.dto.barberServices.BarberServiceSchedulesDTO;

public interface IBarberServiceService {

    BarberServiceDTO findBarberServiceById(Long id);
    List<BarberServiceMinDTO> findAllBarberService();
    List<BarberServiceSchedulesDTO> findBarberServiceSchedules(Long id);
    BarberServiceDTO insertBarberService(BarberServiceDTO BarberServiceToCreate);
    void deleteBarberServiceById(Long id);
    BarberServiceDTO updateBarberService(BarberServiceDTO BarberServiceToUpdate);

}
