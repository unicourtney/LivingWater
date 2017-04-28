package com.livingwater.services.impl;

import com.livingwater.dao.BottleDao;
import com.livingwater.entities.Bottle;
import com.livingwater.entities.User;
import com.livingwater.services.BottleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
@Service("bottleService")
@Transactional
public class BottleServiceImpl implements BottleService{

    @Autowired
    private BottleDao bottleDao;

    public ModelAndView addBottle(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {

            view = new ModelAndView("inventory-bottles");

            String bottle_id = request.getParameter("bottle_id");
            String bottle_type = request.getParameter("bottle_type");
            String status = request.getParameter("status");
            Date date = new Date();
            java.sql.Date date2 = new java.sql.Date(date.getTime());
            Bottle bottle = new Bottle(bottle_id,bottle_type,status,date2);
            bottleDao.create(bottle);
        }

        return view;
    }


    public Bottle getABottle(String id) {
        Bottle bottle = bottleDao.getABottle(id);

        return bottle;
    }

    public List<Bottle> getAllBottle(){

        List<Bottle> bottleList = bottleDao.getAllBottle();

        return  bottleList;
    }

    public ModelAndView updateBottle(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {

            view = new ModelAndView("inventory-bottles");

            String bottle_id = Integer.parseInt(request.getParameter("bottle_id"))+"";
            String status = request.getParameter("status");

            Bottle bottle = bottleDao.getABottle(bottle_id);
            bottle.setStatus(status);
            bottleDao.update(bottle);

            view.addObject("bottlesList",bottleDao.getAllBottle());

        }

        return view;

    }


}
