package com.astontech.hr.repositories;

import com.astontech.hr.domain.ElementType;
import com.astontech.hr.domain.VehicleType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleTypeRepository extends CrudRepository<VehicleType, Integer> {

    VehicleType findByVehicleTypeName(String vehicleTypeName);

    List<VehicleType> findAllByVehicleTypeName(String vehicleTypeName);

    VehicleType findByVehicleTypeId(Integer vehicleTypeId);

    List<VehicleType> findAllByVehicleTypeId(Integer vehicleTypeId);


}
