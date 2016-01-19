package com.usion.service;

import com.usion.service.GenericManager;
import com.usion.model.Parking;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface ParkingManager extends GenericManager<Parking, Long> {
    
}