package com.livingwater.controllers;

import com.livingwater.entities.Batch;
import com.livingwater.entities.Delivery;
import com.livingwater.entities.DeliveryTeam;
import com.livingwater.entities.User;
import com.livingwater.services.BatchService;
import com.livingwater.services.DeliveryService;
import com.livingwater.services.DeliveryTeamService;
import com.livingwater.services.UserService;
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
 * Created by CourtneyLove on 4/24/2017.
 */

@Controller
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private BatchService batchService;

    @Autowired
    private UserService userService;

    @Autowired
    private DeliveryTeamService deliveryTeamService;


    @RequestMapping(value = "/inventory/delivery/info/{id}", method = RequestMethod.GET)
    public ModelAndView deliveryInfoPage(@PathVariable("id") Integer id) {
        ModelAndView view = new ModelAndView("delivery-info");
        return view;
    }

    @RequestMapping(value = "/inventory/delivery", method = RequestMethod.GET)
    public ModelAndView inventoryDeliveryPage(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView view = new ModelAndView("inventory-delivery");

        List<Batch> batchList = batchService.getAllBatch();

        List<Delivery> deliveryList = deliveryService.getAllDelivery();

        List<User> userList = userService.getAllUsers();

        List<DeliveryTeam> deliveryTeamList = deliveryTeamService.getAllDeliveryTeam();

        view.addObject("deliveryList", deliveryList);
        view.addObject("userList", userList);
        view.addObject("deliveryTeamList", deliveryTeamList);
        view.addObject("batchList", batchList);

        return view;
    }

    //----------------------Add

    @RequestMapping(value = "/createDelivery", method = RequestMethod.POST)
    public ModelAndView createDelivery(HttpServletRequest request, HttpServletResponse response) {
        return deliveryService.createDelivery(request, response);
    }
}
