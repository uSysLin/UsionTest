package com.usion.webapp.controller;

import com.usion.dao.SearchException;
import com.usion.service.ParkingManager;
import com.usion.model.Parking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/parkings*")
public class ParkingController {
    private ParkingManager parkingManager;

    @Autowired
    public void setParkingManager(ParkingManager parkingManager) {
        this.parkingManager = parkingManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Model handleRequest(@RequestParam(required = false, value = "q") String query)
    throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(parkingManager.search(query, Parking.class));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(parkingManager.getAll());
        }
        return model;
    }
}
