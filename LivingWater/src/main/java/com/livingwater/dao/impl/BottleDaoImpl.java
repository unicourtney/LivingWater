package com.livingwater.dao.impl;

import com.livingwater.dao.BottleDao;
import com.livingwater.dao.RoleDao;
import com.livingwater.entities.Bottle;
import com.livingwater.entities.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
@Repository("bottleDao")
@Transactional
public class BottleDaoImpl extends GenericDaoImpl<Bottle> implements BottleDao {

}
