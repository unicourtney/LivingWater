package com.livingwater.dao.impl;

import com.livingwater.dao.DeliveryTeamDao;
import com.livingwater.dao.RoleDao;
import com.livingwater.entities.Delivery;
import com.livingwater.entities.DeliveryTeam;
import com.livingwater.entities.Role;
import com.livingwater.entities.User;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
@Repository("deliveryTeamDao")
@Transactional
public class DeliveryTeamDaoImpl extends GenericDaoImpl<DeliveryTeam> implements DeliveryTeamDao {

    public List<DeliveryTeam> getAllDeliveryTeam() {
        Query query = getCurrentSession().createQuery("from DeliveryTeam b");
        return query.list();
    }

    public boolean isInDeliveryTeam(Delivery delivery, User user) {
        Query query = getCurrentSession().createQuery("from DeliveryTeam b where b.deliveryID = :delivery and b.user = :user");
        query.setParameter("delivery",delivery);
        query.setParameter("user",user);

        if(query.uniqueResult() != null){
            return true;
        }
        else {
            return false;
        }
    }
}
