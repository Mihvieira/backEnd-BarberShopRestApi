package com.barbershop.api.service.interfaces;

import java.util.List;

import com.barbershop.api.dto.barberServices.BarberServiceDTO;
import com.barbershop.api.dto.barberServices.BarberServiceMinDTO;
import com.barbershop.api.dto.barberServices.BarberServiceSchedulesDTO;
import com.barbershop.api.entity.BarberService;

public interface IBarberServiceService {

    BarberServiceDTO findById(Long id);

    List<BarberServiceMinDTO> findAll();

    BarberServiceSchedulesDTO findSchedules(Long id);

    BarberServiceDTO insert(BarberServiceDTO barberServiceToCreate);

    void delete(Long id);

    BarberServiceDTO update(BarberServiceDTO barberServiceToUpdate);

}
