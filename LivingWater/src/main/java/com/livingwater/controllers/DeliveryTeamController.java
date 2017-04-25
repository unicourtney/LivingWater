package com.livingwater.controllers;

import com.livingwater.dao.DeliveryTeamDao;
import com.livingwater.entities.*;
import com.livingwater.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by CourtneyLove on 4/15/2017.
 */

@Controller
public class DeliveryTeamController {

    @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private UserService userService;

    @Autowired
    private DeliveryTeamService deliveryTeamService;

    @Autowired
    private DeliveryTeamDao deliveryTeamDao;


    //----------------------Add

    @RequestMapping(value = "/addDeliveryTeam", method = RequestMethod.POST)
    public ModelAndView addUserToTeam(HttpServletRequest request, HttpServletResponse response) {

        return deliveryTeamService.addUserToTeam(request, response);
    }
}
