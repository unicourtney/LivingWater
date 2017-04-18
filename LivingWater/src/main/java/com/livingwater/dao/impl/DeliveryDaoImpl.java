package com.livingwater.dao.impl;

import com.livingwater.dao.DeliveryDao;
import com.livingwater.dao.RoleDao;
import com.livingwater.entities.Delivery;
import com.livingwater.entities.Role;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
@Repository("deliveryDao")
@Transactional
public class DeliveryDaoImpl extends GenericDaoImpl<Delivery> implements DeliveryDao {

    public List<Delivery> getAllDelivery() {
        Query query = getCurrentSession().createQuery("from Delivery b");
        return query.list();
    }

    public Delivery getADelivery(int id) {
        Query query = getCurrentSession().createQuery("from Delivery b where b.deliveryID = :id");
        query.setParameter("id",id);

        return (Delivery) query.uniqueResult();
    }
}
