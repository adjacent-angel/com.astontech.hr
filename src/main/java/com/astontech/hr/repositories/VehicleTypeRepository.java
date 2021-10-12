package com.astontech.hr.repositories;

import com.astontech.hr.domain.VehicleType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleTypeRepository extends CrudRepository<VehicleType, Integer> {

    VehicleType findByVehicleYearAndVehiclePlate(int vehicleYear, String vehiclePlate);

}
