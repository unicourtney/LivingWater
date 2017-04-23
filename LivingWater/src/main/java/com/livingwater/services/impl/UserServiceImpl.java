package com.livingwater.services.impl;

import com.livingwater.dao.RoleDao;
import com.livingwater.dao.UserDao;
import com.livingwater.entities.Role;
import com.livingwater.entities.User;
import com.livingwater.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by John Leeroy Gadiane on 16/04/2017.
 */
@Service("employeeService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserDao userDao;

    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView view = new ModelAndView("employee-profiles");

        String user_name = request.getParameter("user_name");
        String username = request.getParameter("username");
        String password = DigestUtils.md5DigestAsHex(request.getParameter("user_password").getBytes());
        String user_role = request.getParameter("user_role");

        Role role = roleDao.getRole(user_role);

        User user = new User(user_name, username, password, role);

        userDao.create(user);

        List<User> userList = userDao.getAllUsers();

        view.addObject("userList", userList);

        return view;
    }

    public List<User> getAllUsers() {

        List<User> userList = userDao.getAllUsers();

        return userList;
    }

    public User getUser(int id) {

        User user = userDao.getUser(id);

        return user;
    }

    public ModelAndView updateUser(int id, HttpServletRequest request, HttpServletResponse response) {

        ModelAndView view = new ModelAndView("employee-info");


        String user_name = request.getParameter("user_name");
        String username = request.getParameter("username");
        String password = DigestUtils.md5DigestAsHex(request.getParameter("user_password").getBytes());
        String user_role = request.getParameter("user_role");

        Role role = roleDao.getRole(user_role);

        User user = new User(id, user_name, username, password, role);

        userDao.update(user);

        user = userDao.getUser(id);
        role = roleDao.getRole(user.getRole().getName());

        view.addObject("user", user);
        view.addObject("role", role);

        return view;

    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.POST)
    public ModelAndView deleteUser(int id) {

        ModelAndView view = new ModelAndView("employee-profiles");

        User user = new User();
        user.setUserID(id);

        userDao.delete(user);

        List<User> userList = userDao.getAllUsers();
        view.addObject("userList", userList);

        return view;
    }
}
