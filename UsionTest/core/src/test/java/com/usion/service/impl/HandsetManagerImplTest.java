package com.usion.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.usion.dao.HandsetDao;
import com.usion.model.Handset;
import com.usion.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class HandsetManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private HandsetManagerImpl manager;

    @Mock
    private HandsetDao dao;


    @Test
    public void testGetHandset() {
        log.debug("testing get...");
        //given
        final Long id = 7L;
        final Handset handset = new Handset();
        given(dao.get(id)).willReturn(handset);

        //when
        Handset result = manager.get(id);

        //then
        assertSame(handset, result);
    }

    @Test
    public void testGetHandsets() {
        log.debug("testing getAll...");
        //given
        final List handsets = new ArrayList();
        given(dao.getAll()).willReturn(handsets);

        //when
        List result = manager.getAll();

        //then
        assertSame(handsets, result);
    }

    @Test
    public void testSaveHandset() {
//        log.debug("testing save...");
//
//        //given
//        final Handset handset = new Handset();
//        // enter all required fields
//        handset.setDevId("RjLaDqJfElFpHxDgLmAxEnLhWeWeUnHkNaXwFyAxGeIaQfKhIs");
//        handset.setInnerId("KxBnEpIqYkPyCmYmAdMdHbDbKyCvJiZkPkHqLxIwIkMkAsZbJh");
//        
//
//
//        given(dao.save(handset)).willReturn(handset);
//
//        //when
//        manager.save(handset);
//
//        //then
//        verify(dao).save(handset);
    }

    @Test
    public void testRemoveHandset() {
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