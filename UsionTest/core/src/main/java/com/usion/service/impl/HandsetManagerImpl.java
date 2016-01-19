package com.usion.service.impl;

import com.usion.dao.HandsetDao;
import com.usion.model.Handset;
import com.usion.service.HandsetManager;
import com.usion.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("handsetManager")
@WebService(serviceName = "HandsetService", endpointInterface = "com.usion.service.HandsetManager")
public class HandsetManagerImpl extends GenericManagerImpl<Handset, Long> implements HandsetManager {
    HandsetDao handsetDao;

    @Autowired
    public HandsetManagerImpl(HandsetDao handsetDao) {
        super(handsetDao);
        this.handsetDao = handsetDao;
    }
}