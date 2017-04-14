package com.livingwater.dao.impl;

import com.livingwater.dao.RoleDao;
import com.livingwater.dao.SupplyDao;
import com.livingwater.entities.Role;
import com.livingwater.entities.Supply;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
@Repository("supplyDao")
@Transactional
public class SupplyDaoImpl extends GenericDaoImpl<Supply> implements SupplyDao {

}
