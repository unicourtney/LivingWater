package com.livingwater.services.impl;

import com.livingwater.dao.RoleDao;
import com.livingwater.dao.UserDao;
import com.livingwater.entities.Role;
import com.livingwater.entities.User;
import com.livingwater.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by John Leeroy Gadiane on 16/04/2017.
 */
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserDao userDao;

    public ModelAndView addEmployee(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView("employee-profile");

        String name = request.getParameter("employee_name");
        String username = request.getParameter("employee_username");
        String password = request.getParameter("employee_password");

        Role role = roleDao.getRole("employee_role");

        User user = new User(name,username,password,role);

        userDao.create(user);

        return view;
    }
}
