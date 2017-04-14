package com.livingwater.dao.impl;

import com.livingwater.dao.UserDao;
import com.livingwater.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
@Repository("userDao")
@Transactional
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

}
