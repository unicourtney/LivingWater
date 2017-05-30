package com.livingwater.dao.impl;

import com.livingwater.dao.DeliveryBottlesDao;
import com.livingwater.entities.Bottle;
import com.livingwater.entities.Delivery;
import com.livingwater.entities.DeliveryBottles;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by John Leeroy Gadiane on 23/05/2017.
 */

@Repository("deliveryBottlesDao")
@Transactional
public class DeliveryBottlesDaoImpl extends GenericDaoImpl<DeliveryBottles> implements DeliveryBottlesDao {


    public boolean isBottlesInDB(Delivery delivery, Bottle bottle) {
        Query query = getCurrentSession().createQuery("from DeliveryBottles where deliveryID = :delivery and bottleID = :bottle");
        query.setParameter("delivery",delivery);
        query.setParameter("bottle",bottle);

        if(query.uniqueResult() == null){
            return false;
        }
        return true;
    }

    public List<DeliveryBottles> getAll(Delivery delivery) {
        Query query = getCurrentSession().createQuery("from DeliveryBottles where deliveryID = :delivery");
        query.setParameter("delivery",delivery);

        return query.list();
    }


}
