package com.usion.dao.hibernate;

import com.usion.model.Handset;
import com.usion.dao.HandsetDao;
import com.usion.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("handsetDao")
public class HandsetDaoHibernate extends GenericDaoHibernate<Handset, Long> implements HandsetDao {

    public HandsetDaoHibernate() {
        super(Handset.class);
    }
}
