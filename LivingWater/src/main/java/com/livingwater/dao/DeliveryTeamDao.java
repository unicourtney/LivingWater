package com.livingwater.dao;

import com.livingwater.entities.Delivery;
import com.livingwater.entities.DeliveryTeam;
import com.livingwater.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("deliveryTeamDao")
@Transactional
public interface DeliveryTeamDao extends GenericDao<DeliveryTeam>{

    public List<DeliveryTeam> getAllDeliveryTeam();

    public boolean isInDeliveryTeam(Delivery delivery, User user);

}
