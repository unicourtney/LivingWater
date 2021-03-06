package com.livingwater.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.livingwater.dao.BottleDao;
import com.livingwater.dao.CustomerDao;
import com.livingwater.dao.RoleDao;
import com.livingwater.dao.TransactionDao;
import com.livingwater.entities.Role;
import com.livingwater.entities.User;
import com.livingwater.services.BatchService;
import com.livingwater.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class UserController {

    //password: 5f4dcc3b5aa765d61d8327deb882cf99

    @Autowired
    private UserService userService;

    @Autowired
    private BatchService batchService;

    @Autowired
    private BottleDao bottleDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private RoleDao roleDao;
    //----------------------Navigation

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView view = new ModelAndView("login");
        return view;
    }

    @RequestMapping(value = "/inventory/supplies", method = RequestMethod.GET)
    public ModelAndView inventorySuppliesPage(HttpServletRequest request) {
        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {

            view = new ModelAndView("inventory-supplies");
        }
        return view;
    }


    @RequestMapping(value = "/profiles/employees", method = RequestMethod.GET)
    public ModelAndView employeeProfilesPage(HttpServletRequest request) {

        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {

            view = new ModelAndView("employee-profiles");

            List<User> userList = userService.getAllUsers();

            view.addObject("userList", userList);
        }
        return view;
    }

    @RequestMapping(value = "/transaction", method = RequestMethod.GET)
    public ModelAndView salesDispensersPage(HttpServletRequest request) {
        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {

            view = new ModelAndView("transaction");
        }
        view.addObject("customerList",customerDao.getAllCustomer());
        view.addObject("transactionsList",transactionDao.getAllTransaction());
        return view;
    }


    @RequestMapping(value = "/profiles/employees/info/{id}", method = RequestMethod.GET)
    public ModelAndView employeeInfoPage(@PathVariable("id") Integer id, HttpServletRequest request) {
        ModelAndView view;


        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {

            view = new ModelAndView("employee-info");

            User user = userService.getUser(id);
            Role role = roleDao.getRole(user.getRole().getName());

            view.addObject("user", user);
            view.addObject("role", role);
        }

        return view;
    }

    @RequestMapping(value = "/inventory/supplies/info", method = RequestMethod.GET)
    public ModelAndView supplyInfoPage(HttpServletRequest request) {
        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {

            view = new ModelAndView("supply-info");
        }
        return view;
    }

    //----------------------Login

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView userLogin(HttpServletRequest request, HttpServletResponse response) {
        return userService.userLogin(request, response);
    }

    //----------------------Logout

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView userLogout(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView("login");

        request.getSession().invalidate();
        return view;
    }

    //----------------------Add

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response) {

        return userService.addUser(request, response);
    }

    //----------------------Edit

    @RequestMapping(value = "/editUser/{id}", method = RequestMethod.POST)
    public ModelAndView editCustomer(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) {


        return userService.updateUser(id, request, response);
    }


    //----------------------Delete

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public ModelAndView deleteProfilesCustomer(@PathVariable("id") Integer id, HttpServletRequest request) {

        return userService.deleteUser(id, request);
    }
}
