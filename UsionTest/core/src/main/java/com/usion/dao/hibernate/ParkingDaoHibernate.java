package com.usion.dao.hibernate;

import com.usion.model.Parking;
import com.usion.dao.ParkingDao;
import com.usion.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("parkingDao")
public class ParkingDaoHibernate extends GenericDaoHibernate<Parking, Long> implements ParkingDao {

    public ParkingDaoHibernate() {
        super(Parking.class);
    }
}
