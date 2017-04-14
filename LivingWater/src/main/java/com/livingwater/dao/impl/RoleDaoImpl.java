package com.livingwater.dao.impl;

import com.livingwater.dao.RoleDao;
import com.livingwater.dao.UserDao;
import com.livingwater.entities.Role;
import com.livingwater.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
@Repository("roleDao")
@Transactional
public class RoleDaoImpl extends GenericDaoImpl<Role> implements RoleDao {

}
