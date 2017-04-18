package com.livingwater.dao.impl;

import com.livingwater.dao.DispenserDao;
import com.livingwater.dao.RoleDao;
import com.livingwater.entities.Dispenser;
import com.livingwater.entities.Role;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
@Repository("dispenserDao")
@Transactional
public class DispenserDaoImpl extends GenericDaoImpl<Dispenser> implements DispenserDao {

    public List<Dispenser> getAllDispenser() {
        Query query = getCurrentSession().createQuery("from Dispenser b");
        return query.list();
    }
}
