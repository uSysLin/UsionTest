package com.usion.service.impl;

import com.usion.dao.ParkingDao;
import com.usion.model.Parking;
import com.usion.service.ParkingManager;
import com.usion.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("parkingManager")
@WebService(serviceName = "ParkingService", endpointInterface = "com.usion.service.ParkingManager")
public class ParkingManagerImpl extends GenericManagerImpl<Parking, Long> implements ParkingManager {
    ParkingDao parkingDao;

    @Autowired
    public ParkingManagerImpl(ParkingDao parkingDao) {
        super(parkingDao);
        this.parkingDao = parkingDao;
    }
}