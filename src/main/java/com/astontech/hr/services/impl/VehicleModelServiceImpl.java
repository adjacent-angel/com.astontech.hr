package com.astontech.hr.services.impl;

import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.domain.VehicleType;
import com.astontech.hr.repositories.VehicleModelRepository;
import com.astontech.hr.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleModelServiceImpl implements VehicleModelService {

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    @Override
    public Iterable<VehicleModel> listAllVehicleModel() {
        return vehicleModelRepository.findAll();
    }

    @Override
    public VehicleModel getVehicleModelById(Integer vehicleModelId) {
        return vehicleModelRepository.findById(vehicleModelId).orElse(null);
    }

    @Override
    public VehicleModel saveVehicleModel(VehicleModel vehicleModel) {
        return vehicleModelRepository.save(vehicleModel);
    }

    @Override
    public Iterable<VehicleModel> saveVehicleModelList(Iterable<VehicleModel> vehicleModelIterable) {
        return vehicleModelRepository.saveAll(vehicleModelIterable);
    }

    @Override
    public void deleteVehicleModel(Integer vehicleModelId) {
        vehicleModelRepository.deleteById(vehicleModelId);
    }

    @Override
    public void deleteTypeFromModel(VehicleType vehicleType) {
        vehicleModelRepository.deleteById(vehicleType.getVehicleTypeId());
    }

}
