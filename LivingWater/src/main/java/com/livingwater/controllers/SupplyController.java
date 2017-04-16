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
 * Created by CourtneyLove on 4/16/2017.
 */
@Controller
public class SupplyController {

    //----------------------Add

    @RequestMapping(value = "/addSupply", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, ModelMap map) {

        ModelAndView view = new ModelAndView("inventory-supplies");
        String supply_name = request.getParameter("supply_name");
        String supply_quantity = request.getParameter("supply_quantity");


        System.out.println("MATERIAL: " + supply_name
                + "\nQUANTITY: " + supply_quantity);

        return view;
    }
}
