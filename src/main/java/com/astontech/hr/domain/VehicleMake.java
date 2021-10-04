package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;


@Entity
public class VehicleMake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VehicleMakeId")
    private Integer vehicleMakeId;

    @Version
    private Integer version;

   private String vehicleMakeName;


   @ManyToOne
   private VehicleType vehicleType;



    public VehicleMake() {}

   public VehicleMake(Integer vehicleMakeId) {
      this.setVehicleMakeId(vehicleMakeId);
   }

    public VehicleMake(String vehicleMakeName) {
       this.setVehicleMakeName(vehicleMakeName);
    }

    public VehicleMake(String vehicleMakeName, List<VehicleModel> vehicleModelList) {
    }

    public Integer getVehicleMakeId() {
        return vehicleMakeId;
    }

    public void setVehicleMakeId(Integer vehicleMakeId) {
        this.vehicleMakeId = vehicleMakeId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getVehicleMakeName() {
        return vehicleMakeName;
    }

    public void setVehicleMakeName(String vehicleMakeName) {
        this.vehicleMakeName = vehicleMakeName;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void add(VehicleMake vehicleMake) {
    }



    @Override
    public String toString() {
        return "VehicleMake{" +
                "vehicleMakeId=" + vehicleMakeId +
                ", version=" + version +
                ", vehicleMakeName='" + vehicleMakeName + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
