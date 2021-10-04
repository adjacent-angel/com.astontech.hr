package com.astontech.hr.services;

import com.astontech.hr.domain.VehicleMake;

public interface VehicleMakeService {

    Iterable<VehicleMake> listAllVehicleMake();

    VehicleMake getVehicleMakeById(Integer vehicleMakeId);

    VehicleMake getVehicleMakeByName (String vehicleMakeName);

    VehicleMake saveVehicleMake(VehicleMake vehicleMake);

    Iterable<VehicleMake> saveVehicleMakeList(Iterable<VehicleMake> vehicleMakeIterable);

    void deleteVehicleMake(Integer vehicleMakeId);

    VehicleMake findByVehicleMakeName(String vehicleMakeName);
}
