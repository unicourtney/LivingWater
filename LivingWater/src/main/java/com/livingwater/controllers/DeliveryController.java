package com.livingwater.controllers;

import com.google.gson.Gson;
import com.livingwater.dao.*;
import com.livingwater.entities.*;
import com.livingwater.services.BatchService;
import com.livingwater.services.DeliveryService;
import com.livingwater.services.DeliveryTeamService;
import com.livingwater.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
    private BatchDao batchDao;

    @Autowired
    private VehicleDao vehicleDao;

    @Autowired
    private DeliveryTeamService deliveryTeamService;

    @Autowired
    private DeliveryTeamDao deliveryTeamDao;

    @Autowired
    private DeliveryDao deliveryDao;

    @Autowired
    private BottleDao bottleDao;

    @Autowired
    private DeliveryBottlesDao deliveryBottlesDao;

    @RequestMapping(value = "/inventory/delivery/info/{id}", method = RequestMethod.GET)
    public ModelAndView deliveryInfoPage(@PathVariable("id") Integer id, HttpServletRequest request) {
        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {

            view = new ModelAndView("delivery-info");
        }
        return view;
    }

    @RequestMapping(value = "/inventory/delivery", method = RequestMethod.GET)
    public ModelAndView inventoryDeliveryPage(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {

            view = new ModelAndView("inventory-delivery");


        List<Batch> batchList = batchDao.getAllBatch();

            List<Delivery> deliveryList = deliveryService.getAllDelivery();

            List<User> userList = userService.getAllUsers();

            List<DeliveryTeam> deliveryTeamList = deliveryTeamService.getAllDeliveryTeam();

            List<Vehicle> vehicles = vehicleDao.getAllVehicles();

            view.addObject("deliveryList", deliveryList);
            view.addObject("userList", userList);
            view.addObject("deliveryTeamList", deliveryTeamList);
            view.addObject("batchList", batchList);
            view.addObject("vehicleList",vehicles);
            view.addObject("bottlesList",bottleDao.getAllBottle());
        }

        return view;
    }

    //----------------------Add

    @RequestMapping(value = "/createDelivery", method = RequestMethod.POST)
    public ModelAndView createDelivery(HttpServletRequest request, HttpServletResponse response) {

        return deliveryService.createDelivery(request, response);
    }

    @RequestMapping(value = "/viewMembers/{deliveryID}", method = RequestMethod.GET)
    @ResponseBody
    public String viewMembers(@PathVariable("deliveryID") String deliveryID){
        int id = Integer.parseInt(deliveryID);
        System.out.println(deliveryID);
        Delivery delivery = deliveryDao.getADelivery(id);
        Vehicle vehicle = vehicleDao.getVehicle(delivery.getVehicle().getPlateNumber());

        List<DeliveryTeam> deliveryTeams = deliveryTeamDao.getDeliveryTeam(delivery);

        for (DeliveryTeam deliveryTeam: deliveryTeams) {
            System.out.println(deliveryTeam.getDelivery().getDeliveryID() + " " + deliveryTeam.getUser().getUserID());
        }

        Gson gson = new Gson();

        String json = gson.toJson(deliveryTeams);

        return json;

    }

    @RequestMapping(value = "/addBottleDelivery", method = RequestMethod.POST)
    public ModelAndView addBottleDelivery(HttpServletRequest request, HttpServletResponse response) {
        return deliveryService.addBottleDelivery(request,response);
    }

    @RequestMapping(value = "/viewBottles/{deliveryID}", method = RequestMethod.GET)
    @ResponseBody
    public String viewBottles(@PathVariable("deliveryID") String deliveryID){
        int id = Integer.parseInt(deliveryID);
        System.out.println(deliveryID);
        Delivery delivery = deliveryDao.getADelivery(id);

        List<DeliveryBottles> deliveryBottles = deliveryBottlesDao.getAll(delivery);


        Gson gson = new Gson();

        String json = gson.toJson(deliveryBottles);

        return json;

    }
}
