package com.astontech.hr.controllers;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.domain.VO.ElementVO;

import com.astontech.hr.services.ElementTypeService;
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
public class AdminController {

    @Autowired
    private ElementTypeService elementTypeService;

    private Logger log = LogManager.getLogger(AdminController.class);

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminHome() {
        return "admin/adminHome";
    }

    @RequestMapping(value = "/admin/element/add", method = RequestMethod.GET)
    public String adminElementGet(Model model) {
        model.addAttribute("elementVO", new ElementVO());
        model.addAttribute("warningAlert", "visible");
        return "admin/element_management/element_add";
    }

    @RequestMapping(value = "/admin/element/add", method = RequestMethod.POST)
    public String adminElementPost(ElementVO elementVO, Model model) {
        elementVO.splitNewElementsIntoArray();
        logElementVO(elementVO);
        saveElementTypeAndElementsFromVO(elementVO);

        boolean success = true;
        if(success)
            model.addAttribute("successAlert", "visible");
        else
            model.addAttribute("errorAlert", "visible");
        model.addAttribute("elementVO", new ElementVO());
        return "admin/element_management/element_add";
    }

    @RequestMapping(value = "/admin/element/list", method = RequestMethod.GET)
    public String adminElementList(Model model) {
        model.addAttribute("elementTypeList", elementTypeService.listAllElementTypes());
        return "admin/element_management/element_list";
    }

    @RequestMapping(value = "/admin/element/edit/{elementTypeId}", method = RequestMethod.GET)
    public String elementTypeEdit(@PathVariable int elementTypeId, Model model) {
        ElementType elementType = elementTypeService.getElementTypeById(elementTypeId);

        model.addAttribute("elementType", elementType);
        return"admin/element_management/element_edit";
    }

    @RequestMapping(value = "/admin/element/delete/{elementTypeId}", method = RequestMethod.GET)
    public String elementTypeDelete(@PathVariable int elementTypeId) {
        elementTypeService.deleteElementType(elementTypeId);
        return "redirect:/admin/element/list";
    }

    @RequestMapping(value = "/admin/element/update", method = RequestMethod.POST)
    public String elementTypeUpdate(ElementType elementType, Model model, @RequestParam("inputNewElement") String newElement) {
        // if new element (unbound text box) has a value, add it to the list
        if(!newElement.equals("")) {
            if(elementType.getElementList() == null) {
                List<Element> elementList = new ArrayList<Element>();
                elementList.add(new Element(newElement));
                elementType.setElementList(elementList);
            } else {
                elementType.getElementList().add(new Element(newElement));
            }
        }

        //iterate through list of elements
        for(int i = 0; i < elementType.getElementList().size(); i++) {
            //check to see if element is empty
            if(elementType.getElementList().get(i).getElementName().equals("")) {
                //element name is blank, remove from list.
                elementType.getElementList().remove(i);
            }
        }

        elementTypeService.saveElementType(elementType);
        return "redirect:/admin/element/edit/" + elementType.getElementTypeId();
    }





    // region HELPER METHODS

    private void saveElementTypeAndElementsFromVO(ElementVO elementVO) {
        List<Element> newElementList = new ArrayList<>();
        for(String str : elementVO.getNewElementArray()) {
            newElementList.add(new Element(str));
        }
        ElementType newElementType = new ElementType(elementVO.getNewElementType());
        newElementType.setElementList(newElementList);

        elementTypeService.saveElementType(newElementType);

    }

    private void logElementVO(ElementVO elementVO) {
        log.info("New Element Type: " + elementVO.getNewElementType());

        for(String str : elementVO.getNewElementArray()) {
            log.info("New Element: " + str);
        }

    }

    // endregion
}
