package com.usion.dao;

import com.usion.dao.BaseDaoTestCase;
import com.usion.model.Handset;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HandsetDaoTest extends BaseDaoTestCase {
    @Autowired
    private HandsetDao handsetDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveHandset() {
        Handset handset = new Handset();

        // enter all required fields
        handset.setDevId("JbJfPdPxCmDxBoEfMhWgMdXrBpKoHvTqSoAoFsLdViNySqUrCo");
        handset.setInnerId("EuDlNzAoIvKzArUlYtLfPrMkWvBjSnVbApZsEjOgUhZoIdZmYq");

        log.debug("adding handset...");
        handset = handsetDao.save(handset);

        handset = handsetDao.get(handset.getId());

        assertNotNull(handset.getId());

        log.debug("removing handset...");

        handsetDao.remove(handset.getId());

        // should throw DataAccessException 
        handsetDao.get(handset.getId());
    }
}