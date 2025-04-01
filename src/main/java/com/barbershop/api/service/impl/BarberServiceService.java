package com.barbershop.api.service.impl;

import java.util.List;

import com.barbershop.api.dto.barberServices.BarberServiceDTO;
import com.barbershop.api.dto.barberServices.BarberServiceMinDTO;
import com.barbershop.api.dto.barberServices.BarberServiceSchedulesDTO;
import com.barbershop.api.service.interfaces.IBarberServiceService;

public class BarberServiceService implements IBarberServiceService{

    @Override
    public BarberServiceDTO findBarberServiceById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findBarberServiceById'");
    }

    @Override
    public List<BarberServiceMinDTO> findAllBarberService() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllBarberService'");
    }

    @Override
    public List<BarberServiceSchedulesDTO> findBarberServiceSchedules(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findBarberServiceSchedules'");
    }

    @Override
    public BarberServiceDTO insertBarberService(BarberServiceDTO BarberServiceToCreate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertBarberService'");
    }

    @Override
    public void deleteBarberServiceById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBarberServiceById'");
    }

    @Override
    public BarberServiceDTO updateBarberService(BarberServiceDTO BarberServiceToUpdate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBarberService'");
    }

}
