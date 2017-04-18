package com.livingwater.services.impl;

import com.livingwater.dao.DeliveryDao;
import com.livingwater.dao.DeliveryTeamDao;
import com.livingwater.dao.UserDao;
import com.livingwater.entities.Delivery;
import com.livingwater.entities.DeliveryTeam;
import com.livingwater.entities.User;
import com.livingwater.services.DeliveryTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by John Leeroy Gadiane on 19/04/2017.
 */
@Service("deliveryTeamService")
@Transactional
public class DeliveryTeamServiceImpl implements DeliveryTeamService{

    @Autowired
    private DeliveryDao deliveryDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private DeliveryTeamDao deliveryTeamDao;

    public ModelAndView addDeliveryTeam(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("delivery-team-profiles");

        Delivery delivery = deliveryDao.getADelivery(Integer.parseInt(request.getParameter("deliveryteam_id")));
        User user = userDao.getAUser(Integer.parseInt(request.getParameter("deliveryteam_user")));

        DeliveryTeam deliveryTeam = new DeliveryTeam(delivery,user);

        deliveryTeamDao.create(deliveryTeam);

        return mav;

    }
}