package com.livingwater.dao.impl;

import com.livingwater.dao.RoleDao;
import com.livingwater.entities.Role;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
@Repository("roleDao")
@Transactional
public class RoleDaoImpl extends GenericDaoImpl<Role> implements RoleDao {

    public Role getRole(String roleName) {
        Query query = getCurrentSession().createQuery("from Role r where r.name = :roleName");
        query.setParameter("roleName",roleName);
        return (Role)query.uniqueResult();



    }
}
