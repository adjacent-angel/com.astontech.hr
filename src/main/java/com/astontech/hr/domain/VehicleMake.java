package com.astontech.hr.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

   @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   private List<VehicleModel> vehicleModelList;

    //region CONSTRUCTORS
    public VehicleMake() {}

    public VehicleMake(String vehicleMakeName) {
        this.setVehicleMakeName(vehicleMakeName);
    }

    //endregion

    //region GET/SET

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

    public List<VehicleModel> getVehicleModelList() {
        return vehicleModelList;
    }

    public void setVehicleModelList(List<VehicleModel> vehicleModelList) {
        this.vehicleModelList = vehicleModelList;
    }

    //endregion

    //region CUSTOM

    @Override
    public String toString() {
        return "VehicleMake{" +
                "vehicleMakeId=" + vehicleMakeId +
                ", version=" + version +
                ", vehicleMakeName='" + vehicleMakeName + '\'' +
                ", vehicleModelList=" + vehicleModelList +
                '}';
    }

    //endregion

}
