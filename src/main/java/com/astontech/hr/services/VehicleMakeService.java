package com.astontech.hr.services;

import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;

import java.util.List;

public interface VehicleMakeService {

    Iterable<VehicleMake> listAllVehicleMake();

    VehicleMake getVehicleMakeById(Integer vehicleMakeId);

    VehicleMake saveVehicleMake(VehicleMake vehicleMake);

    Iterable<VehicleMake> saveVehicleMakeList(Iterable<VehicleMake> vehicleMakeIterable);

    void deleteVehicleMake(Integer vehicleMakeId);

    void deleteModelFromMake(VehicleModel vehicleModel);

}
