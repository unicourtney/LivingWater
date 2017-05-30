package com.livingwater.services.impl;

import com.livingwater.dao.*;
import com.livingwater.entities.*;
import com.livingwater.services.BatchService;
import com.livingwater.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by CourtneyLove on 4/24/2017.
 */

@Service("deliveryService")
@Transactional
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private BatchService batchService;

    @Autowired
    private BatchDao batchDao;

    @Autowired
    private DeliveryDao deliveryDao;

    @Autowired
    private VehicleDao vehicleDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private DeliveryTeamDao deliveryTeamDao;

    @Autowired
    private DeliveryBottlesDao deliveryBottlesDao;

    @Autowired
    private BottleDao bottleDao;

    public ModelAndView createDelivery(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");
        java.util.Date date = new java.util.Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        if (user1 == null) {

            view = new ModelAndView("login");
        } else {
            view = new ModelAndView("inventory-delivery");

            Delivery delivery = new Delivery();
            delivery.setVehicle(vehicleDao.getVehicle(Integer.parseInt(request.getParameter("plateNumber"))));
            delivery.setStatus("Okay");
            delivery.setDate(timestamp);
            deliveryDao.create(delivery);
            DeliveryTeam deliveryTeam = new DeliveryTeam();
            deliveryTeam.setVehicle(delivery.getVehicle());
            deliveryTeam.setDelivery(delivery);
            deliveryTeam.setUser(userDao.getUser(Integer.parseInt(request.getParameter("contactPerson"))));
            deliveryTeam.setDesignation("Contact Person");
            deliveryTeamDao.create(deliveryTeam);

            String[] ids = request.getParameterValues("members");
            int count = 1;
            while(request.getParameter("members"+count)!=null){
                deliveryTeam = new DeliveryTeam();
                deliveryTeam.setVehicle(delivery.getVehicle());
                deliveryTeam.setDelivery(delivery);
                deliveryTeam.setUser(userDao.getUser(Integer.parseInt(request.getParameter("members"+count))));
                deliveryTeam.setDesignation("Helper");
                deliveryTeamDao.create(deliveryTeam);
                count++;
            }


        }
        List<Delivery> deliveryList = deliveryDao.getAllDelivery();

        List<User> userList = userDao.getAllUsers();

        List<DeliveryTeam> deliveryTeamList = deliveryTeamDao.getAllDeliveryTeam();

        List<Vehicle> vehicles = vehicleDao.getAllVehicles();

        view.addObject("deliveryList", deliveryList);
        view.addObject("userList", userList);
        view.addObject("deliveryTeamList", deliveryTeamList);
        view.addObject("vehicleList",vehicles);

        return view;
    }

    public List<Delivery> getAllDelivery() {
        List<Delivery> deliveryList = deliveryDao.getAllDelivery();

        return deliveryList;
    }

    public ModelAndView addBottleDelivery(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("inventory-delivery");
        Delivery delivery = deliveryDao.getADelivery(Integer.parseInt(request.getParameter("deliveryBottle_id")));
        Bottle bottle_id = bottleDao.getABottle(request.getParameter("deliveryBottle_bottle"));

        if (!deliveryBottlesDao.isBottlesInDB(delivery, bottle_id)) {
            DeliveryBottles deliveryBottles = new DeliveryBottles();
            deliveryBottles.setDelivery(delivery);
            deliveryBottles.setBottle(bottle_id);
            deliveryBottlesDao.create(deliveryBottles);
            bottle_id.setStatus("Delivered");
            bottleDao.update(bottle_id);
        }
        List<Delivery> deliveryList = deliveryDao.getAllDelivery();

        List<User> userList = userDao.getAllUsers();

        List<DeliveryTeam> deliveryTeamList = deliveryTeamDao.getAllDeliveryTeam();

        List<Vehicle> vehicles = vehicleDao.getAllVehicles();

        mav.addObject("deliveryList", deliveryList);
        mav.addObject("userList", userList);
        mav.addObject("deliveryTeamList", deliveryTeamList);
        mav.addObject("vehicleList",vehicles);
        mav.addObject("bottlesList",bottleDao.getAllBottle());
        return mav;
    }
}
