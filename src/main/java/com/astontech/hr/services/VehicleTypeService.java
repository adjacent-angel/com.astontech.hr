package com.astontech.hr.services;

import com.astontech.hr.domain.VehicleType;

public interface VehicleTypeService {

    Iterable<VehicleType> listAllVehicleType();

    VehicleType getVehicleTypeById(Integer vehicleTypeId);

    VehicleType getVehicleTypeByName(String vehicleTypeName);

    VehicleType saveVehicleType(VehicleType vehicleType);

    Iterable<VehicleType> saveVehicleTypeList(Iterable<VehicleType> vehicleTypeIterable);

    void deleteVehicleType(Integer vehicleTypeId);

    VehicleType findByVehicleTypeName(String vehicleTypeName);
}
