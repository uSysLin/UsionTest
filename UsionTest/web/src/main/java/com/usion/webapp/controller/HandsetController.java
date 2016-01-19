package com.usion.webapp.controller;

import com.usion.dao.SearchException;
import com.usion.service.HandsetManager;
import com.usion.model.Handset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/handsets*")
public class HandsetController {
    private HandsetManager handsetManager;

    @Autowired
    public void setHandsetManager(HandsetManager handsetManager) {
        this.handsetManager = handsetManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Model handleRequest(@RequestParam(required = false, value = "q") String query)
    throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(handsetManager.search(query, Handset.class));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(handsetManager.getAll());
        }
        return model;
    }
}
