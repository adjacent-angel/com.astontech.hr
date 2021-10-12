package com.astontech.hr.services.impl;

import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.repositories.VehicleMakeRepository;
import com.astontech.hr.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleMakeServiceImpl implements VehicleMakeService {

    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    @Override
    public Iterable<VehicleMake> listAllVehicleMake() {
        return vehicleMakeRepository.findAll();
    }

    @Override
    public VehicleMake getVehicleMakeById(Integer vehicleMakeId) {
        return vehicleMakeRepository.findById(vehicleMakeId).orElse(null);
    }

    @Override
    public VehicleMake saveVehicleMake(VehicleMake vehicleMake) {
        return vehicleMakeRepository.save(vehicleMake);
    }

    @Override
    public Iterable<VehicleMake> saveVehicleMakeList(Iterable<VehicleMake> vehicleMakeIterable) {
        return vehicleMakeRepository.saveAll(vehicleMakeIterable);
    }

    @Override
    public void deleteVehicleMake(Integer vehicleMakeId) {
        vehicleMakeRepository.deleteById(vehicleMakeId);
    }

    @Override
    public void deleteModelFromMake(VehicleModel vehicleModel) {
        vehicleMakeRepository.deleteById(vehicleModel.getVehicleModelId());

    }

}

