package com.livingwater.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by CourtneyLove on 4/15/2017.
 */

@Controller
public class DeliveryTeamController {

    //----------------------Add

    @RequestMapping(value = "/addDeliveryTeam", method = RequestMethod.POST)
    public ModelAndView addCustomer(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        ModelAndView view = new ModelAndView("delivery-team-profiles");

        String deliveryteam_id = request.getParameter("deliveryteam_id");
        String deliveryteam_user = request.getParameter("deliveryteam_user");

        System.out.println("DELIVERY ID: " + deliveryteam_id
                + "\nUSER: " + deliveryteam_user
        );

        return view;
    }
}
