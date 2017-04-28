package com.livingwater.services.impl;

import com.livingwater.dao.SupplyDao;
import com.livingwater.entities.Supply;
import com.livingwater.entities.User;
import com.livingwater.services.SuppliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.ServiceMode;

/**
 * Created by John Leeroy Gadiane on 19/04/2017.
 */
@Service("supplyService")
@Transactional
public class SuppliesServiceImpl implements SuppliesService{

    @Autowired
    private SupplyDao supplyDao;

    public ModelAndView addSupply(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            mav = new ModelAndView("login");
        } else {

            mav = new ModelAndView("inventory-supplies");

            String supply_name = request.getParameter("supply_name");
            int supply_quantity = Integer.parseInt(request.getParameter("supply_quantity"));

            Supply supply = new Supply(supply_name,supply_quantity);
            supplyDao.create(supply);

        }

        return mav;
    }
}
