package com.astontech.hr.bootstrap;

import com.astontech.hr.domain.*;
import com.astontech.hr.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ElementService elementService;

    @Autowired
    private ElementTypeService elementTypeService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private VehicleModelService vehicleModelService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        generateElementAndElementTypes();
    }

    private void generateElementAndElementTypes() {

        ElementType laptopType = new ElementType("Laptop");

        List<Element> elementList = new ArrayList<>();
        elementList.add(new Element("Acer"));
        elementList.add(new Element("Dell"));
        elementList.add(new Element("Samsung"));
        elementList.add(new Element("Apple"));
        elementList.add(new Element("Asus"));

        laptopType.setElementList(elementList);

        elementTypeService.saveElementType(laptopType);

        // ========================================================

        ElementType cellphoneType = new ElementType("CellPhone");

        List<Element> elementList2 = new ArrayList<>();
        elementList2.add(new Element("Apple"));
        elementList2.add(new Element("Samsung"));
        elementList2.add(new Element("LG"));
        elementList2.add(new Element("Motorola"));
        elementList2.add(new Element("Asus"));

        cellphoneType.setElementList(elementList2);

        elementTypeService.saveElementType(cellphoneType);

        // ========================================================

        ElementType emailType = new ElementType("Email");

        List<Element> emailList = new ArrayList<>();
        emailList.add(new Element("Work"));
        emailList.add(new Element("Personal"));
        emailList.add(new Element("Delegated"));

        emailType.setElementList(emailList);

        elementTypeService.saveElementType(emailType);

        // ========================================================

        VehicleMake testMake = new VehicleMake("Test");

        List<VehicleModel> testModelList = new ArrayList<>();
        testModelList.add(new VehicleModel("test model 1"));
        testModelList.add(new VehicleModel("test model 2"));
        testModelList.add(new VehicleModel("test model 3"));

        testMake.setVehicleModelList(testModelList);

        vehicleMakeService.saveVehicleMake(testMake);
    }
}
