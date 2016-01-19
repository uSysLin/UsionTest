package com.usion.webapp.controller;

import org.apache.commons.lang.StringUtils;
import com.usion.service.RateManager;
import com.usion.model.Rate;
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
@RequestMapping("/rateform*")
public class RateFormController extends BaseFormController {
    private RateManager rateManager = null;

    @Autowired
    public void setRateManager(RateManager rateManager) {
        this.rateManager = rateManager;
    }

    public RateFormController() {
        setCancelView("redirect:rates");
        setSuccessView("redirect:rates");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Rate showForm(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return rateManager.get(new Long(id));
        }

        return new Rate();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Rate rate, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(rate, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "rateform";
            }
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (rate.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            rateManager.remove(rate.getId());
            saveMessage(request, getText("rate.deleted", locale));
        } else {
            rateManager.save(rate);
            String key = (isNew) ? "rate.added" : "rate.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:rateform?id=" + rate.getId();
            }
        }

        return success;
    }
}
