package com.livingwater.dao;

import com.livingwater.entities.Role;
import com.livingwater.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("roleDao")
@Transactional
public interface RoleDao extends GenericDao<Role>{

}
