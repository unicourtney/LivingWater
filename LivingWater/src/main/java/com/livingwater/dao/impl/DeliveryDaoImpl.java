package com.livingwater.dao.impl;

import com.livingwater.dao.DeliveryDao;
import com.livingwater.dao.RoleDao;
import com.livingwater.entities.Delivery;
import com.livingwater.entities.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
@Repository("deliveryDao")
@Transactional
public class DeliveryDaoImpl extends GenericDaoImpl<Delivery> implements DeliveryDao {

}
