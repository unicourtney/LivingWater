package com.livingwater.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;

/**
 * Created by CourtneyLove on 4/14/2017.
 */

@Controller
public class CustomerController {

    //----------------------Add

    @RequestMapping(value="/addCustomer", method = RequestMethod.POST)
    public ModelAndView addCustomer(HttpServletRequest request, HttpServletResponse response, ModelMap map){
        ModelAndView view = new ModelAndView("customer-profiles");

        String customer_name = request.getParameter("customer_name");
        String customer_address = request.getParameter("customer_address");
        Long customer_contact = Long.parseLong(request.getParameter("customer_contact"));
        String customer_type = request.getParameter("customer_type");
        Double customer_pricing = Double.parseDouble(request.getParameter("customer_pricing"));

        System.out.println("CUSTOMER NAME: " + customer_name
                + "\nCUSTOMER ADDRESS: " + customer_address
                + "\nCUSTOMER NUMBER: " + customer_contact
                + "\nCUSTOMER TYPE: " + customer_type
                + "\nCUSTOMER PRICING: " + customer_pricing);

        return view;
    }
}
