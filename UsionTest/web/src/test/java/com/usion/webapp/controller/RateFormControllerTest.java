package com.usion.webapp.controller;

import com.usion.webapp.controller.BaseControllerTestCase;
import com.usion.model.Rate;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RateFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private RateFormController form;
    private Rate rate;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/rateform");
        request.addParameter("id", "-1");

        rate = form.showForm(request);
        assertNotNull(rate);
    }

    @Test
    public void testSave() throws Exception {
        request = newGet("/rateform");
        request.addParameter("id", "-1");

        rate = form.showForm(request);
        assertNotNull(rate);

        request = newPost("/rateform");

        rate = form.showForm(request);
        // update required fields
        rate.setName("KzVzQsDkKzWtQlRbMySzVhLuSpQnPkOwIhKdCsJrAwAoZoBxRm");

        BindingResult errors = new DataBinder(rate).getBindingResult();
        form.onSubmit(rate, errors, request, new MockHttpServletResponse());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

    @Test
    public void testRemove() throws Exception {
        request = newPost("/rateform");
        request.addParameter("delete", "");
        rate = new Rate();
        rate.setId(-2L);

        BindingResult errors = new DataBinder(rate).getBindingResult();
        form.onSubmit(rate, errors, request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }
}
