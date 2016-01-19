package com.usion.service;

import com.usion.service.GenericManager;
import com.usion.model.Handset;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface HandsetManager extends GenericManager<Handset, Long> {
    
}