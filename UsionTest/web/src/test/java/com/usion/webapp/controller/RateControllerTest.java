package com.usion.webapp.controller;

import com.usion.service.RateManager;
import com.usion.model.Rate;

import com.usion.webapp.controller.BaseControllerTestCase;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.*;

public class RateControllerTest extends BaseControllerTestCase {
    @Autowired
    private RateController controller;

    @Test
    public void testHandleRequest() throws Exception {
        Model model = controller.handleRequest(null);
        Map m = model.asMap();
        assertNotNull(m.get("rateList"));
        assertTrue(((List) m.get("rateList")).size() > 0);
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        RateManager rateManager = (RateManager) applicationContext.getBean("rateManager");
        rateManager.reindex();

        Model model = controller.handleRequest("*");
        Map m = model.asMap();
        List results = (List) m.get("rateList");
        assertNotNull(results);
        assertEquals(3, results.size());
    }
}