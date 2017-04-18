package com.livingwater.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by CourtneyLove on 4/18/2017.
 */
@Controller
public class DeliveryController {

    @RequestMapping(value = "/createTransaction", method = RequestMethod.POST)
    public ModelAndView createTransaction(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        ModelAndView view = new ModelAndView("customer-delivery-bottles");

        Integer customer_id = Integer.parseInt(request.getParameter("customer_id"));
        String bottle_case = request.getParameter("bottle_case");
        Double delivery_price = Double.parseDouble(request.getParameter("delivery_price"));
        String delivery_date = request.getParameter("delivery_date");

        request.getSession().setAttribute("session_customer_id", customer_id);
        request.getSession().setAttribute("session_bottle_case", bottle_case);
        request.getSession().setAttribute("session_delivery_price", delivery_price);
        request.getSession().setAttribute("session_delivery_date", delivery_date);

        System.out.println("CUSTOMER ID: " + customer_id
                + "\nBOTTLE CASE: " + bottle_case
                + "\nPRICE: " + delivery_price
                + "\nDELIVERY DATE: " + delivery_date);

        return view;
    }

    @RequestMapping(value = "/addTransaction", method = RequestMethod.POST)
    public ModelAndView addTransaction(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        ModelAndView view = new ModelAndView("customer-delivery-bottles");

        Integer customer_id = Integer.parseInt(request.getParameter("customer_id"));
        String bottle_case = request.getParameter("bottle_case");
        Double delivery_price = Double.parseDouble(request.getParameter("delivery_price"));
        String delivery_date = request.getParameter("delivery_date");

        System.out.println("CUSTOMER ID: " + customer_id
                + "\nBOTTLE CASE: " + bottle_case
                + "\nPRICE: " + delivery_price
                + "\nDELIVERY DATE: " + delivery_date);

        return view;
    }
}
