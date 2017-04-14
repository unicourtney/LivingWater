package com.livingwater.dao.impl;

import com.livingwater.dao.DeliveryTeamDao;
import com.livingwater.dao.RoleDao;
import com.livingwater.entities.DeliveryTeam;
import com.livingwater.entities.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
@Repository("deliveryTeamDao")
@Transactional
public class DeliveryTeamDaoImpl extends GenericDaoImpl<DeliveryTeam> implements DeliveryTeamDao {

}
