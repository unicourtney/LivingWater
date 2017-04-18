package com.livingwater.dao.impl;

import com.livingwater.dao.RoleDao;
import com.livingwater.dao.SupplyDao;
import com.livingwater.entities.Role;
import com.livingwater.entities.Supply;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
@Repository("supplyDao")
@Transactional
public class SupplyDaoImpl extends GenericDaoImpl<Supply> implements SupplyDao {

    public List<Supply> getAllSupply() {
        Query query = getCurrentSession().createQuery("from Supply b");
        return query.list();
    }
}
