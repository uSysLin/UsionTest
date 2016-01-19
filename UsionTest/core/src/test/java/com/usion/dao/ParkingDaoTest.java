package com.usion.dao;

import com.usion.dao.BaseDaoTestCase;
import com.usion.model.Parking;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ParkingDaoTest extends BaseDaoTestCase {
    @Autowired
    private ParkingDao parkingDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveParking() {
        Parking parking = new Parking();

        // enter all required fields
        parking.setParkingName("YjRjRqXkZpPkWeJhTeTwWiUkCyKzCjFoLqXqVhMqVdWiDyRoMx");
        parking.setParkingStatus("RyQtZcMyNaGkGpFqOfEpZhFzLgXtIwGdDbKjOaXxQmNaTbBmKv");

        log.debug("adding parking...");
        parking = parkingDao.save(parking);

        parking = parkingDao.get(parking.getId());

        assertNotNull(parking.getId());

        log.debug("removing parking...");

        parkingDao.remove(parking.getId());

        // should throw DataAccessException 
        parkingDao.get(parking.getId());
    }
}