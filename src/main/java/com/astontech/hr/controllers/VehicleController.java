package com.astontech.hr.controllers;

import com.astontech.hr.domain.VO.VehicleVO;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.domain.VehicleType;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleModelService;
import com.astontech.hr.services.VehicleTypeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Controller
public class VehicleController {

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private VehicleModelService vehicleModelService;


    private Logger log = LogManager.getLogger(VehicleController.class);


    @RequestMapping(value = "admin/vehicle/add", method = RequestMethod.GET)
    public String adminVehicleGet(Model model) {
        model.addAttribute("vehicleVO", new VehicleVO());

        return "admin/vehicle_management/vehicle_add";
    }

    @RequestMapping(value = "/admin/vehicle/add", method = RequestMethod.POST)
    public String adminVehiclePost(VehicleVO vehicleVO, Model model) {
        saveVehicleTypeAndVehicleFromVO(vehicleVO);
        boolean success = true;
        if(success)
            model.addAttribute("successAlert", "visible");
        else
            model.addAttribute("errorAlert", "visible");
        model.addAttribute("vehicleVO", new VehicleVO());

        return "admin/vehicle_management/vehicle_add";
    }

    @RequestMapping(value = "/admin/vehicle/list", method = RequestMethod.GET)
    public String adminVehicleList(Model model) {
        model.addAttribute("vehicleTypeList", vehicleTypeService.listAllVehicleType());
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMake());
        model.addAttribute("vehicleModelList", vehicleModelService.listAllVehicleModel());


        return "admin/vehicle_management/vehicle_list";
    }

    @RequestMapping(value="/admin/vehicle/edit", method = RequestMethod.GET)
    public String adminVehicleEditList(Model model) {
        model.addAttribute("vehicleTypeList", vehicleTypeService.listAllVehicleType());
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMake());
        model.addAttribute("vehicleModelList", vehicleModelService.listAllVehicleModel());

        return "admin/vehicle_management/vehicle_edit";
    }

    @RequestMapping(value = "/admin/vehicle/type/edit", method = RequestMethod.GET)
    public String vehicleTypeEdit( Model model) {
        model.addAttribute("vehicleTypeList", vehicleTypeService.listAllVehicleType());

        return "admin/vehicle_management/vehicle_type_edit";
    }

    @RequestMapping(value = "/admin/vehicle/make/edit", method = RequestMethod.GET)
    public String vehicleMakeEdit(Model model) {
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMake());

        return "admin/vehicle_management/vehicle_edit";
    }

    @RequestMapping(value = "admin/vehicle/model/edit", method = RequestMethod.GET)
    public String vehicleModelEdit(Model model) {
        model.addAttribute("vehicleModelList", vehicleModelService.listAllVehicleModel());

        return "admin/vehicle_management/vehicle_edit";
    }

    @RequestMapping(value = "/admin/vehicle/delete/{vehicleTypeId}", method = RequestMethod.GET)
    public String vehicleTypeDelete(@PathVariable int vehicleTypeId) {
        vehicleTypeService.deleteVehicleType(vehicleTypeId);
        return "redirect:/admin/vehicle/list";
    }

    @RequestMapping(value = "/admin/vehicle/update", method = RequestMethod.POST)
    public String vehicleTypeUpdate(VehicleType vehicleType, VehicleMake vehicleMake, VehicleModel vehicleModel, Model model, @RequestParam("inputNewVehicleType") String newVehicleType ,@RequestParam("inputNewVehicleMake") String newVehicleMake, @RequestParam("inputNewVehicleModel") String newVehicleModel) {
        if (!newVehicleModel.equals("")) {
            if (vehicleModelService.listAllVehicleModel() == null) {
                List<VehicleModel> vehicleModelList = new ArrayList<VehicleModel>();
                vehicleModelList.add(new VehicleModel(newVehicleModel));
                vehicleModelService.saveVehicleModelList(vehicleModelList);
            } else {
                vehicleModel = vehicleModelService.getVehicleModelById(vehicleModel.getVehicleModelId());
            }
        }

        for (VehicleModel vehicleModel1 : vehicleModelService.listAllVehicleModel()) {
            if (vehicleModel1.getVehicleModelName().equals("")) {
                vehicleModelService.deleteVehicleModel(vehicleModel1.getVehicleModelId());
            }
        }

            if (!newVehicleMake.equals("")) {
                if (vehicleMakeService.listAllVehicleMake() == null) {
                    List<VehicleMake> vehicleMakeList = new ArrayList<VehicleMake>();
                    vehicleMakeList.add(new VehicleMake(newVehicleMake));
                    vehicleMakeService.saveVehicleMakeList(vehicleMakeList);
                } else {
                    vehicleMake = vehicleMakeService.getVehicleMakeById(vehicleMake.getVehicleMakeId());
                }
            }

            for (VehicleMake vehicleMake1 : vehicleMakeService.listAllVehicleMake()) {
                if (vehicleMake1.getVehicleMakeName().equals("")) {
                    vehicleMakeService.deleteVehicleMake(vehicleMake1.getVehicleMakeId());
                }
            }

            if (!newVehicleType.equals("")) {
                if (vehicleTypeService.listAllVehicleType() == null) {
                    List<VehicleType> vehicleTypeList = new ArrayList<VehicleType>();
                    vehicleTypeList.add(new VehicleType(newVehicleType));
                    vehicleTypeService.saveVehicleTypeList(vehicleTypeList);
                } else {
                    vehicleType = vehicleTypeService.getVehicleTypeById(vehicleType.getVehicleTypeId());
                }
            }

            for (VehicleType vehicleType1 : vehicleTypeService.listAllVehicleType()) {
                if (vehicleType1.getVehicleTypeName().equals("")) {
                    vehicleTypeService.deleteVehicleType(vehicleType1.getVehicleTypeId());
                }
            }

            vehicleTypeService.saveVehicleType(vehicleType);
            vehicleMakeService.saveVehicleMake(vehicleMake);
            vehicleModelService.saveVehicleModel(vehicleModel);

            return "redirect:/admin/vehicle/edit/" + vehicleType.getVehicleTypeName();
        }

    // region HELPER METHODS
    private void saveVehicleTypeAndVehicleFromVO(VehicleVO vehicleVO) {

        VehicleType newVehicleType;
        if (vehicleTypeService.getVehicleTypeByName(vehicleVO.getNewVehicleTypeName()) == null) {
            newVehicleType = new VehicleType(vehicleVO.getNewVehicleTypeName());
            vehicleTypeService.saveVehicleType(newVehicleType);
        } else {
            newVehicleType = vehicleTypeService.getVehicleTypeByName(vehicleVO.getNewVehicleTypeName());
        }

        VehicleMake newVehicleMake = new VehicleMake(vehicleVO.getNewVehicleMakeName());
        newVehicleMake.setVehicleType(newVehicleType);
        vehicleMakeService.saveVehicleMake(newVehicleMake);

        VehicleModel newVehicleModel = new VehicleModel(vehicleVO.getNewVehicleModelName());
        newVehicleModel.setVehicleMake(newVehicleMake);
        vehicleModelService.saveVehicleModel(newVehicleModel);
    }

    // endregion
//
//    @RequestMapping(value="/admin/vehicle/type/update", method = RequestMethod.POST)
//    public String vehicleTypeNameEdit(VehicleType vehicleType, Model model, @RequestParam("inputNewVehicleType") String newVehicleType) {
////        model.addAttribute("vehicleTypeEditList", vehicleTypeService.listAllVehicleType());
//        if (!newVehicleType.equals("")) {
//            if (vehicleTypeService.listAllVehicleType() == null) {
//                List<VehicleType> vehicleTypeList = new ArrayList<VehicleType>();
//                vehicleTypeList.add(new VehicleType(newVehicleType));
//                vehicleTypeService.saveVehicleTypeList(vehicleTypeList);
//            } else {
//                vehicleType = vehicleTypeService.getVehicleTypeById(vehicleType.getVehicleTypeId());
//            }
//        }
//
//        for (VehicleType vehicleType1 : vehicleTypeService.listAllVehicleType()) {
//            if (vehicleType1.getVehicleTypeName().equals("")) {
//                vehicleTypeService.deleteVehicleType(vehicleType1.getVehicleTypeId());
//            }
//        }
//        vehicleTypeService.saveVehicleType(vehicleType);
//
//        return "admin/vehicle_management/vehicle_type_edit"  + vehicleType.getVehicleTypeName();
//    }

}
