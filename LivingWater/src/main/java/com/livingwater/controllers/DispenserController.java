package com.livingwater.controllers;

import com.livingwater.entities.Customer;
import com.livingwater.entities.Dispenser;
import com.livingwater.services.CustomerService;
import com.livingwater.services.DispenserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by CourtneyLove on 4/23/2017.
 */
@Controller
public class DispenserController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private DispenserService dispenserService;

    @RequestMapping(value = "/profiles/customers/rent-dispenser/{id}", method = RequestMethod.GET)
    public ModelAndView rentDispenserPage(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView("customer-dispensers");

        Customer customer = customerService.getCustomer(id);

        request.getSession().setAttribute("session_customer_name", customer.getName());
        request.getSession().setAttribute("session_customer_id", customer.getCustomerID());

        List<Dispenser> dispenserList = dispenserService.getAllDispenserFromCustomer(id);

        if (dispenserList != null) {
            view.addObject("dispenserList", dispenserList);
        }
        view.addObject("customer", customer);
        return view;
    }

    @RequestMapping(value = "/addDispenser", method = RequestMethod.POST)
    public ModelAndView addDispenser(HttpServletRequest request, HttpServletResponse response) {

        return dispenserService.addDispenser(request, response);
    }

    @RequestMapping(value = "/deleteDispenser/{id}", method = RequestMethod.GET)
    public ModelAndView deleteTransactionBottles(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) {

        return dispenserService.deleteDispenser(id, request, response);
    }
}
