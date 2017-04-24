package com.livingwater.services;

import com.livingwater.entities.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by John Leeroy Gadiane on 16/04/2017.
 */
public interface UserService {

    public List<User> getAllUsers();

    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response);

    public User getUser(int id);

    public ModelAndView updateUser(int id, HttpServletRequest request, HttpServletResponse response);

    public ModelAndView deleteUser(int id);
}
