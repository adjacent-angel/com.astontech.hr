package com.astontech.hr.repositories;

import com.astontech.hr.domain.VehicleModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleModelRepository extends CrudRepository<VehicleModel, Integer> {

    VehicleModel findByVehicleModelName(String vehicleModelName);

    List<VehicleModel> findAllByVehicleModelName(String vehicleModelName);

    VehicleModel findByVehicleModelId(Integer vehicleModelId);

    List<VehicleModel> findAllByVehicleModelId(Integer vehicleModelId);
}
