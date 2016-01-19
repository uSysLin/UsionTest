package com.usion.webapp.controller;

import org.apache.commons.lang.StringUtils;
import com.usion.service.ParkingManager;
import com.usion.model.Parking;
import com.usion.webapp.controller.BaseFormController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
@RequestMapping("/parkingform*")
public class ParkingFormController extends BaseFormController {
    private ParkingManager parkingManager = null;

    @Autowired
    public void setParkingManager(ParkingManager parkingManager) {
        this.parkingManager = parkingManager;
    }

    public ParkingFormController() {
        setCancelView("redirect:parkings");
        setSuccessView("redirect:parkings");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Parking showForm(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return parkingManager.get(new Long(id));
        }

        return new Parking();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Parking parking, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(parking, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "parkingform";
            }
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (parking.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            parkingManager.remove(parking.getId());
            saveMessage(request, getText("parking.deleted", locale));
        } else {
            parkingManager.save(parking);
            String key = (isNew) ? "parking.added" : "parking.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:parkingform?id=" + parking.getId();
            }
        }

        return success;
    }
}
