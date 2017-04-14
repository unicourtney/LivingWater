package com.livingwater.dao;

import com.livingwater.entities.DeliveryTeam;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("deliveryTeamDao")
@Transactional
public interface DeliveryTeamDao extends GenericDao<DeliveryTeam>{

}
