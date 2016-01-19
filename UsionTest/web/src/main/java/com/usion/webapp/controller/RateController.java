package com.usion.webapp.controller;

import com.usion.dao.SearchException;
import com.usion.service.RateManager;
import com.usion.model.Rate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rates*")
public class RateController {
    private RateManager rateManager;

    @Autowired
    public void setRateManager(RateManager rateManager) {
        this.rateManager = rateManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Model handleRequest(@RequestParam(required = false, value = "q") String query)
    throws Exception {
        Model model = new ExtendedModelMap();
        try {
            model.addAttribute(rateManager.search(query, Rate.class));
        } catch (SearchException se) {
            model.addAttribute("searchError", se.getMessage());
            model.addAttribute(rateManager.getAll());
        }
        return model;
    }
}
