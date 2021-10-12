package com.astontech.hr.controllers;

import com.astontech.hr.domain.VO.VehicleVO;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleModelService;
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
import java.util.List;


@Controller
public class VehicleController {

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private VehicleModelService vehicleModelService;

    private Logger log = LogManager.getLogger(VehicleController.class);


    @RequestMapping(value = "/admin/vehicle/add", method = RequestMethod.GET)
    public String adminVehicleGet(Model model) {
        model.addAttribute("vehicleVO", new VehicleVO());
        model.addAttribute("warningAlert", "visible");
        return "admin/vehicle_management/vehicle_add";
    }

    @RequestMapping(value ="/admin/vehicle/add", method = RequestMethod.POST)
    public String adminVehiclePost(VehicleVO vehicleVO, Model model) {
        vehicleVO.getNewVehicleModelArray();
        logVehicleVO(vehicleVO);
        saveVehicleMakeTypeFromVO(vehicleVO);

        boolean success = true;
        if(success)
            model.addAttribute("succussAlert", "visible");
        else
            model.addAttribute("errorAlert", "visible");
        model.addAttribute("vehicleVO", new VehicleVO());
        return "admin/vehicle_management/vehicleMake_list";
    }

    @RequestMapping(value = "/admin/vehicleMake/list", method = RequestMethod.GET)
    public String adminVehicleList(Model model) {
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMake());
        return "admin/vehicle_management/vehicleMake_list";
    }

    @RequestMapping(value = "/admin/vehicle/edit/{vehicleMakeId}", method = RequestMethod.GET)
    public String vehicleMakeEdit(@PathVariable int vehicleMakeId, Model model) {
        VehicleMake vehicleMake = vehicleMakeService.getVehicleMakeById(vehicleMakeId);

        model.addAttribute("vehicleMake", vehicleMake);
        return "admin/vehicle_management/vehicle_edit";
    }

    @RequestMapping(value = "/admin/vehicle/delete/{vehicleMakeId}", method = RequestMethod.GET)
    public String vehicleMakeDelete(@PathVariable int vehicleMakeId) {
        vehicleMakeService.deleteVehicleMake(vehicleMakeId);
        return "redirect:/admin/vehicle/list";
    }

    @RequestMapping(value = "/admin/vehicle/update", method = RequestMethod.POST)
    public String vehicleMakeUpdate(VehicleMake vehicleMake, Model model, @RequestParam("inputNewVehicleModel") String newVehicleModel) {
        if(!newVehicleModel.equals("")) {
            if(vehicleMake.getVehicleModelList() == null) {
                List<VehicleModel> vehicleModelList = new ArrayList<VehicleModel>();
                vehicleModelList.add(new VehicleModel(newVehicleModel));
                vehicleMake.setVehicleModelList(vehicleModelList);
            } else {
                vehicleMake.getVehicleModelList().add(new VehicleModel(newVehicleModel));
            }
        }

        for (int i = 0; i < vehicleMake.getVehicleModelList().size(); i++) {
            if(vehicleMake.getVehicleModelList().get(i).getVehicleModelName().equals("")) {
                vehicleMake.getVehicleModelList().remove(i);
            }
        }

        vehicleMakeService.saveVehicleMake(vehicleMake);
        return "redirect:/admin/vehicle/edit/" + vehicleMake.getVehicleMakeId();
    }





    // region HELPER METHODS

    private void saveVehicleMakeTypeFromVO(VehicleVO vehicleVO) {
        List<VehicleModel> newVehicleModelList = new ArrayList<>();
        for(String str : vehicleVO.getNewVehicleModelArray()) {
            newVehicleModelList.add(new VehicleModel(str));
        }

        VehicleMake newVehicleMake = new VehicleMake(vehicleVO.getNewVehicleMake());
        newVehicleMake.setVehicleModelList(newVehicleModelList);

        vehicleMakeService.saveVehicleMake(newVehicleMake);
    }

    private void logVehicleVO(VehicleVO vehicleVO) {
        log.info("New Vehicle Make: " + vehicleVO.getNewVehicleMake());

        for(String str : vehicleVO.getNewVehicleModelArray()) {
            log.info("new Vehicle Model: " + str);
        }
    }



    // endregion
}
