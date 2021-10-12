package com.astontech.hr.domain.VO;

public class VehicleVO {

    private String newVehicleMake;
    private String newVehicleModel;
    private String[] newVehicleModelArray;

    //region CONSTRUCTORS

    public VehicleVO() {}

    //endregion

    //region GET/SET

    public String getNewVehicleMake() {
        return newVehicleMake;
    }

    public void setNewVehicleMake(String newVehicleMake) {
        this.newVehicleMake = newVehicleMake;
    }

    public String getNewVehicleModel() {
        return newVehicleModel;
    }

    public void setNewVehicleModel(String newVehicleModel) {
        this.newVehicleModel = newVehicleModel;
    }

    public String[] getNewVehicleModelArray() {
        return newVehicleModelArray;
    }

    public void setNewVehicleModelArray(String[] newVehicleModelArray) {
        this.newVehicleModelArray = newVehicleModelArray;
    }

    //endregion

    //region CUSTOM

    public void splitVehicleModelArray() {
        this.setNewVehicleModelArray(this.newVehicleModel.split("\\r?\\n"));
    }


    //endregion





}

