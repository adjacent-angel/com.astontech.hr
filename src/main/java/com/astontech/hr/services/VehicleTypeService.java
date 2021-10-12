package com.astontech.hr.services;

import com.astontech.hr.domain.VehicleType;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleTypeService {

    Iterable<VehicleType> listAllVehicleType();

    VehicleType getVehicleTypeById(Integer vehicleTypeId);

    VehicleType saveVehicleType(VehicleType vehicleType);

    Iterable<VehicleType> saveVehicleTypeList(Iterable<VehicleType> vehicleTypeIterable);

    void deleteVehicleType(Integer vehicleTypeId);

}
