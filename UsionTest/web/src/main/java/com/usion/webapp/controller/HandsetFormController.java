package com.usion.webapp.controller;

import org.apache.commons.lang.StringUtils;
import com.usion.service.HandsetManager;
import com.usion.model.Handset;
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
@RequestMapping("/handsetform*")
public class HandsetFormController extends BaseFormController {
    private HandsetManager handsetManager = null;

    @Autowired
    public void setHandsetManager(HandsetManager handsetManager) {
        this.handsetManager = handsetManager;
    }

    public HandsetFormController() {
        setCancelView("redirect:handsets");
        setSuccessView("redirect:handsets");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Handset showForm(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return handsetManager.get(new Long(id));
        }

        return new Handset();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Handset handset, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(handset, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "handsetform";
            }
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (handset.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            handsetManager.remove(handset.getId());
            saveMessage(request, getText("handset.deleted", locale));
        } else {
            handsetManager.save(handset);
            String key = (isNew) ? "handset.added" : "handset.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:handsetform?id=" + handset.getId();
            }
        }

        return success;
    }
}
