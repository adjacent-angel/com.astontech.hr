package com.astontech.hr.services.impl;

import com.astontech.hr.domain.VehicleType;
import com.astontech.hr.repositories.VehicleTypeRepository;
import com.astontech.hr.services.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleTypeServiceImpl implements VehicleTypeService {

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    @Override
    public Iterable<VehicleType> listAllVehicleType() {
        return vehicleTypeRepository.findAll();
    }

    @Override
    public VehicleType getVehicleTypeById(Integer vehicleTypeId) {
        return vehicleTypeRepository.findById(vehicleTypeId).orElse(null);
    }

    @Override
    public VehicleType saveVehicleType(VehicleType vehicleType) {
        return vehicleTypeRepository.save(vehicleType);
    }

    @Override
    public Iterable<VehicleType> saveVehicleTypeList(Iterable<VehicleType> vehicleTypeIterable) {
        return vehicleTypeRepository.saveAll(vehicleTypeIterable);
    }

    @Override
    public void deleteVehicleType(Integer vehicleTypeId) {
        vehicleTypeRepository.deleteById(vehicleTypeId);

    }
}
