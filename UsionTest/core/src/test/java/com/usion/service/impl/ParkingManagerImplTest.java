package com.usion.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.usion.dao.ParkingDao;
import com.usion.model.Parking;
import com.usion.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class ParkingManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private ParkingManagerImpl manager;

    @Mock
    private ParkingDao dao;


    @Test
    public void testGetParking() {
        log.debug("testing get...");
        //given
        final Long id = 7L;
        final Parking parking = new Parking();
        given(dao.get(id)).willReturn(parking);

        //when
        Parking result = manager.get(id);

        //then
        assertSame(parking, result);
    }

    @Test
    public void testGetParkings() {
        log.debug("testing getAll...");
        //given
        final List parkings = new ArrayList();
        given(dao.getAll()).willReturn(parkings);

        //when
        List result = manager.getAll();

        //then
        assertSame(parkings, result);
    }

    @Test
    public void testSaveParking() {
//        log.debug("testing save...");
//
//        //given
//        final Parking parking = new Parking();
//        // enter all required fields
//        parking.setParkingName("JwIsSkOuRoXrMvGuErWuOaKcXlEoPpDyGaMmLvSkYmQyLwWfYq");
//        parking.setParkingStatus("EoAnFrKkFdFnYnJxFoGxOqAsQpHtLlJbQcWnDqOuXeQkUbZrKm");
//        
//
//
//        given(dao.save(parking)).willReturn(parking);
//
//        //when
//        manager.save(parking);
//
//        //then
//        verify(dao).save(parking);
    }

    @Test
    public void testRemoveParking() {
        log.debug("testing remove...");

        //given
        final Long id = -11L;
        willDoNothing().given(dao).remove(id);

        //when
        manager.remove(id);

        //then
        verify(dao).remove(id);
    }
}