package com.livingwater.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.livingwater.dao.BottleDao;
import com.livingwater.dao.RoleDao;
import com.livingwater.entities.Batch;
import com.livingwater.entities.Role;
import com.livingwater.entities.User;
import com.livingwater.services.BatchService;
import com.livingwater.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
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

    private BottleDao bottleDao;


    @Autowired
    private RoleDao roleDao;
    //----------------------Navigation

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView view = new ModelAndView("login");
        return view;
    }

    @RequestMapping(value = "/inventory/bottles", method = RequestMethod.GET)
    public ModelAndView inventoryBottlesPage() {
        ModelAndView view = new ModelAndView("inventory-bottles");
        view.addObject("bottlesList",bottleDao.getAllBottle());
        return view;
    }



    @RequestMapping(value = "/inventory/supplies", method = RequestMethod.GET)
    public ModelAndView inventorySuppliesPage() {
        ModelAndView view = new ModelAndView("inventory-supplies");
        return view;
    }


    @RequestMapping(value = "/profiles/employees", method = RequestMethod.GET)
    public ModelAndView employeeProfilesPage() {
        ModelAndView view = new ModelAndView("employee-profiles");

        List<User> userList = userService.getAllUsers();

        view.addObject("userList", userList);

        return view;
    }

    @RequestMapping(value = "/sales/delivery", method = RequestMethod.GET)
    public ModelAndView salesDeliveryPage() {
        ModelAndView view = new ModelAndView("sales-delivery");
        return view;
    }

    @RequestMapping(value = "/sales/refilling", method = RequestMethod.GET)
    public ModelAndView salesRefillingPage() {
        ModelAndView view = new ModelAndView("sales-refilling");
        return view;
    }

    @RequestMapping(value = "/sales/dispensers", method = RequestMethod.GET)
    public ModelAndView salesDispensersPage() {
        ModelAndView view = new ModelAndView("sales-dispensers");
        return view;
    }


    @RequestMapping(value = "/profiles/employees/info/{id}", method = RequestMethod.GET)
    public ModelAndView employeeInfoPage(@PathVariable("id") Integer id) {
        ModelAndView view = new ModelAndView("employee-info");

        User user = userService.getUser(id);
        Role role = roleDao.getRole(user.getRole().getName());

        view.addObject("user", user);
        view.addObject("role", role);

        return view;
    }

    @RequestMapping(value = "/inventory/supplies/info", method = RequestMethod.GET)
    public ModelAndView supplyInfoPage() {
        ModelAndView view = new ModelAndView("supply-info");
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
    public ModelAndView deleteProfilesCustomer(@PathVariable("id") Integer id) {

        return userService.deleteUser(id);
    }
}
