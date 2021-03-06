package com.livingwater.controllers;

import com.livingwater.dao.DeliveryTeamDao;
import com.livingwater.dao.TransactionDao;
import com.livingwater.entities.Transaction;
import com.livingwater.entities.User;
import com.livingwater.services.DeliveryService;
import com.livingwater.services.DeliveryTeamService;
import com.livingwater.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    private TransactionDao transactionDao;

    @Autowired
    private UserService userService;

    @Autowired
    private DeliveryTeamService deliveryTeamService;

    @RequestMapping(value = "/profiles/delivery-teams", method = RequestMethod.GET)
    public ModelAndView deliveryTeamProfilesPage() {
        ModelAndView view = new ModelAndView("delivery-team-profiles");

        List<Transaction> transactionList = transactionDao.getAllTransaction();
        List<User> userList = userService.getAllUsers();
        return view;
    }


    //----------------------Add

    @RequestMapping(value = "/addDeliveryTeam", method = RequestMethod.POST)
    public ModelAndView addUserToTeam(HttpServletRequest request, HttpServletResponse response) {

        return deliveryTeamService.addUserToTeam(request, response);
    }
}
