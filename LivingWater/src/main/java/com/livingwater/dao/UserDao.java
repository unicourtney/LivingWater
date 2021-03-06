package com.livingwater.dao;

import com.livingwater.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("userDao")
@Transactional
public interface UserDao extends GenericDao<User>{

    public List<User> getAllUsers();

    public User getUser(int id);

    public User getUsername(String username);

}
