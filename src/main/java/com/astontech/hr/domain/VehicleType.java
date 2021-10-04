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

    private String vehicleTypeName;



    public VehicleType() {
    }

    public VehicleType(Integer vehicleTypeId) {
        this.setVehicleTypeId(vehicleTypeId);
    }

    public VehicleType(String vehicleTypeName) {
        this.setVehicleTypeName(vehicleTypeName);
    }


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

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public void setVehicleTypeName(String vehicleTypeName) {
        this.vehicleTypeName = vehicleTypeName;
    }

    @Override
    public String toString() {
        return "VehicleType{" +
                "vehicleTypeId=" + vehicleTypeId +
                ", version=" + version +
                ", vehicleTypeName='" + vehicleTypeName + '\'' +
                '}';
    }

}
