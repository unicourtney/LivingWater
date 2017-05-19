package com.livingwater.services.impl;

import com.livingwater.dao.DeliveryDao;
import com.livingwater.dao.DeliveryTeamDao;
import com.livingwater.dao.UserDao;
import com.livingwater.dao.VehicleDao;
import com.livingwater.entities.Delivery;
import com.livingwater.entities.DeliveryTeam;
import com.livingwater.entities.User;
import com.livingwater.entities.Vehicle;
import com.livingwater.services.DeliveryService;
import com.livingwater.services.DeliveryTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by John Leeroy Gadiane on 19/04/2017.
 */
@Service("deliveryTeamService")
@Transactional
public class DeliveryTeamServiceImpl implements DeliveryTeamService {

    @Autowired
    private DeliveryDao deliveryDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private DeliveryTeamDao deliveryTeamDao;

    @Autowired
    private VehicleDao vehicleDao;

    public ModelAndView addUserToTeam(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {

            view = new ModelAndView("inventory-delivery");

            Delivery delivery = deliveryDao.getADelivery(Integer.parseInt(request.getParameter("deliveryteam_id")));
            User user = userDao.getUser(Integer.parseInt(request.getParameter("deliveryteam_user")));
            Vehicle vehicle = vehicleDao.getVehicle(delivery.getVehicle().getPlateNumber());
            DeliveryTeam deliveryTeam = new DeliveryTeam(vehicle,delivery, user);

            deliveryTeamDao.create(deliveryTeam);

            List<Delivery> deliveryList = deliveryDao.getAllDelivery();

            List<User> userList = userDao.getAllUsers();

            view.addObject("deliveryList", deliveryList);
            view.addObject("userList", userList);

        }

        return view;

    }

    public List<DeliveryTeam> getAllDeliveryTeam() {
        List<DeliveryTeam> deliveryTeamList = deliveryTeamDao.getAllDeliveryTeam();

        return deliveryTeamList;
    }

}
