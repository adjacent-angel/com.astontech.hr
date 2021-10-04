package com.astontech.hr.domain.VO;

import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.domain.VehicleType;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class VehicleVO {

    private String newVehicleTypeName;
    private String newVehicleMakeName;
    private String newVehicleModelName;
    private String[] newVehicleTypeArray;
    private String[] newVehicleMakeArray;
    private String[] newVehicleModelArray;
//    private String[] newVehicleArray;

    private VehicleModel vehicleModel;
    private VehicleMake vehicleMake;
    private VehicleType vehicleType;

    List<VehicleModel> vehicleModelList;
    List<VehicleMake> vehicleMakeList;
    List<VehicleType> vehicleTypeList;

    public VehicleVO() {}


    public String getNewVehicleTypeName() {
        return newVehicleTypeName;
    }

    public void setNewVehicleTypeName(String newVehicleTypeName) {
        this.newVehicleTypeName = newVehicleTypeName;
    }

    public String getNewVehicleMakeName() {
        return newVehicleMakeName;
    }

    public void setNewVehicleMakeName(String newVehicleMakeName) {
        this.newVehicleMakeName = newVehicleMakeName;
    }

    public String getNewVehicleModelName() {
        return newVehicleModelName;
    }

    public void setNewVehicleModelName(String newVehicleModelName) {
        this.newVehicleModelName = newVehicleModelName;
    }

    public String[] getNewVehicleTypeArray() {
        return newVehicleTypeArray;
    }

    public void setNewVehicleTypeArray(String[] newVehicleTypeArray) {
        this.newVehicleTypeArray = newVehicleTypeArray;
    }

    public String[] getNewVehicleMakeArray() {
        return newVehicleMakeArray;
    }

    public void setNewVehicleMakeArray(String[] newVehicleMakeArray) {
        this.newVehicleMakeArray = newVehicleMakeArray;
    }

    public String[] getNewVehicleModelArray() {
        return newVehicleModelArray;
    }

    public void setNewVehicleModelArray(String[] newVehicleModelArray) {
        this.newVehicleModelArray = newVehicleModelArray;
    }

    public VehicleModel getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public VehicleMake getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(VehicleMake vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public List<VehicleModel> getVehicleModelList() {
        return vehicleModelList;
    }

    public void setVehicleModelList(List<VehicleModel> vehicleModelList) {
        this.vehicleModelList = vehicleModelList;
    }

    public List<VehicleMake> getVehicleMakeList() {
        return vehicleMakeList;
    }

    public void setVehicleMakeList(List<VehicleMake> vehicleMakeList) {
        this.vehicleMakeList = vehicleMakeList;
    }

    public List<VehicleType> getVehicleTypeList() {
        return vehicleTypeList;
    }

    public void setVehicleTypeList(List<VehicleType> vehicleTypeList) {
        this.vehicleTypeList = vehicleTypeList;
    }

    @Override
    public String toString() {
        return "VehicleVO{" +
                "newVehicleTypeName='" + newVehicleTypeName + '\'' +
                ", newVehicleMakeName='" + newVehicleMakeName + '\'' +
                ", newVehicleModelName='" + newVehicleModelName + '\'' +
                ", newVehicleTypeArray=" + Arrays.toString(newVehicleTypeArray) +
                ", newVehicleMakeArray=" + Arrays.toString(newVehicleMakeArray) +
                ", newVehicleModelArray=" + Arrays.toString(newVehicleModelArray) +
                ", vehicleModel=" + vehicleModel +
                ", vehicleMake=" + vehicleMake +
                ", vehicleType=" + vehicleType +
                ", vehicleModelList=" + vehicleModelList +
                ", vehicleMakeList=" + vehicleMakeList +
                ", vehicleTypeList=" + vehicleTypeList +
                '}';
    }
}

