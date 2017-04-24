package com.livingwater.dao.impl;

import com.livingwater.dao.UserDao;
import com.livingwater.entities.User;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
@Repository("userDao")
@Transactional
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

    public List<User> getAllUsers() {
        Query query = getCurrentSession().createQuery("from User b");
        return query.list();
    }

    public User getUser(int id) {
        Query query = getCurrentSession().createQuery("from User b where b.userID = :id");
        query.setParameter("id",id);

        return (User)query.uniqueResult();
    }

}
