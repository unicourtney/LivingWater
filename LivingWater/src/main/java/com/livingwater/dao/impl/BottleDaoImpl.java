package com.livingwater.dao.impl;

import com.livingwater.dao.BottleDao;
import com.livingwater.dao.RoleDao;
import com.livingwater.entities.Bottle;
import com.livingwater.entities.Role;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
@Repository("bottleDao")
@Transactional
public class BottleDaoImpl extends GenericDaoImpl<Bottle> implements BottleDao {

    public List<Bottle> getAllBottle() {
        Query query = getCurrentSession().createQuery("from Bottle b");
        return query.list();
    }

    public Bottle getABottle(String id) {
        Query query = getCurrentSession().createQuery("from Bottle b where b.serialNumber = :id");
        query.setParameter("id",id);

        return (Bottle)query.uniqueResult();
    }
}
