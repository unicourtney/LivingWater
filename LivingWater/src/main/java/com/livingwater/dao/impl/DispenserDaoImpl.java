package com.livingwater.dao.impl;

import com.livingwater.dao.DispenserDao;
import com.livingwater.dao.RoleDao;
import com.livingwater.entities.Dispenser;
import com.livingwater.entities.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
@Repository("dispenserDao")
@Transactional
public class DispenserDaoImpl extends GenericDaoImpl<Dispenser> implements DispenserDao {

}
