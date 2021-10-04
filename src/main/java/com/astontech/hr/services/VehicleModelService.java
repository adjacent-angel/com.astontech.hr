package com.astontech.hr.services;

import com.astontech.hr.domain.VehicleModel;

public interface VehicleModelService {

    Iterable<VehicleModel> listAllVehicleModel();

    VehicleModel getVehicleModelById(Integer vehicleModelId);

    VehicleModel getVehicleModelByName(String vehicleModelName);

    VehicleModel saveVehicleModel(VehicleModel vehicleModel);

    Iterable<VehicleModel> saveVehicleModelList(Iterable<VehicleModel> vehicleModelIterable);

    void deleteVehicleModel(Integer vehicleModelId);

    VehicleModel findByVehicleModelName(String vehicleModelName);
}
