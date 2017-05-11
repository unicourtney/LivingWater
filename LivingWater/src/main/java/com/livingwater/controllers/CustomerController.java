package com.livingwater.controllers;

import com.livingwater.entities.Customer;
import com.livingwater.entities.User;
import com.livingwater.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by CourtneyLove on 4/14/2017.
 */

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/profiles/customers", method = RequestMethod.GET)
    public ModelAndView customerProfilesPage(HttpServletRequest request) {
        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {

            view = new ModelAndView("customer-profiles");

            List<Customer> customerList = customerService.getAllCustomer();

            view.addObject("customerList", customerList);
        }
        return view;
    }

    @RequestMapping(value = "/profiles/customers/info/{id}", method = RequestMethod.GET)
    public ModelAndView customerInfoPage(@PathVariable("id") Integer id, HttpServletRequest request) {
        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {

            view = new ModelAndView("customer-info");

            Customer customer = customerService.getCustomer(id);

            view.addObject("customer", customer);
        }
        return view;
    }

    //----------------------Add

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public ModelAndView addCustomer(HttpServletRequest request, HttpServletResponse response) {
        return customerService.addCustomer(request, response);
    }

    //----------------------Edit

    @RequestMapping(value = "/editCustomer/{id}", method = RequestMethod.POST)
    public ModelAndView editCustomer(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) {


        return customerService.updateCustomer(id, request, response);
    }

    //----------------------Delete

    @RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.GET)
    public ModelAndView deleteCustomer(@PathVariable("id") Integer id, HttpServletRequest request) {

        return customerService.deleteCustomer(id, request);
    }


}
