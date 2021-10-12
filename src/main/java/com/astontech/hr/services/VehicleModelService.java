package com.astontech.hr.services;

import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.domain.VehicleType;

import java.util.List;

public interface VehicleModelService {

    Iterable<VehicleModel> listAllVehicleModel();

    VehicleModel getVehicleModelById(Integer vehicleModelId);

    VehicleModel saveVehicleModel(VehicleModel vehicleModel);

    Iterable<VehicleModel> saveVehicleModelList(Iterable<VehicleModel> vehicleModelIterable);

    void deleteVehicleModel(Integer vehicleModelId);

    void deleteTypeFromModel(VehicleType vehicleType);

}
