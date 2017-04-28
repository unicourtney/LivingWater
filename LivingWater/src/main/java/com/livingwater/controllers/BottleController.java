package com.livingwater.controllers;

import com.livingwater.entities.Bottle;
import com.livingwater.entities.User;
import com.livingwater.services.BottleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
public class BottleController {

    @Autowired
    private BottleService bottleService;

    @RequestMapping(value = "/inventory/bottles", method = RequestMethod.GET)
    public ModelAndView inventoryBottlesPage(HttpServletRequest request) {
        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {

            view = new ModelAndView("inventory-bottles");
            List<Bottle> bottleList = bottleService.getAllBottle();
            view.addObject("bottlesList", bottleList);

        }
        return view;
    }


    //----------------------Add

    @RequestMapping(value = "/addBottle", method = RequestMethod.POST)
    public ModelAndView addBottle(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        return bottleService.addBottle(request, response);
    }

    //----------------------Edit/Update

    @RequestMapping(value = "/updateBottle", method = RequestMethod.POST)
    public ModelAndView updateBottle(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        return bottleService.updateBottle(request, response);
    }
}
