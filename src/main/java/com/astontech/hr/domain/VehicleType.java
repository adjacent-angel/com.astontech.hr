package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class VehicleType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VehicleTypeId")
    private Integer vehicleTypeId;

    @Version
    private Integer version;

    private Integer vehicleYear;
    private String vehiclePlate;


    //region CONSTRUCTORS

    public VehicleType() {
    }

    public VehicleType(Integer vehicleYear, String vehiclePlate) {
        this.setVehicleYear(vehicleYear);
        this.setVehiclePlate(vehiclePlate);

    }

    public VehicleType(Integer vehicleYear) {
        this.setVehicleYear(vehicleYear);
    }

    public VehicleType(String vehiclePlate) {
        this.setVehiclePlate(vehiclePlate);
    }


    //endregion

    //region GET/SET


    public Integer getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(Integer vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(Integer vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }


//endregion

    //region CUSTOM

    @Override
    public String toString() {
        return "VehicleType{" +
                "vehicleTypeId=" + vehicleTypeId +
                ", version=" + version +
                ", vehicleYear=" + vehicleYear +
                ", vehiclePlate='" + vehiclePlate + '\'' +
                '}';
    }


    //endregion

}
