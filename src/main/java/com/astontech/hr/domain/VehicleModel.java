package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;


@Entity
public class VehicleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VehicleModelId")
    private Integer vehicleModelId;

    @Version
    private Integer version;

    private String vehicleModelName;

    @ManyToOne
    private VehicleMake vehicleMake;



    public VehicleModel() {}


    public VehicleModel(Integer vehicleModelId) {
        this.setVehicleModelId(vehicleModelId);
    }

    public VehicleModel(String vehicleModelName) {
        this.setVehicleModelName(vehicleModelName);
    }

    public Integer getVehicleModelId() {
        return vehicleModelId;
    }

    public void setVehicleModelId(Integer vehicleModelId) {
        this.vehicleModelId = vehicleModelId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getVehicleModelName() {
        return vehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }

    public void add(VehicleModel vehicleModel) {
    }

    public VehicleMake getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(VehicleMake vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    @Override
    public String toString() {
        return "VehicleModel{" +
                "vehicleModelId=" + vehicleModelId +
                ", version=" + version +
                ", vehicleModelName='" + vehicleModelName + '\'' +
                ", vehicleMake=" + vehicleMake +
                '}';
    }
}
