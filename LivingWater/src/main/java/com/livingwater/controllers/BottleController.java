package com.livingwater.controllers;

import com.livingwater.services.BottleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class BottleController {

    @Autowired
    private BottleService bottleService;

    //----------------------Add

    @RequestMapping(value="/addBottle", method = RequestMethod.POST)
    public ModelAndView addBottle(HttpServletRequest request, HttpServletResponse response, ModelMap map){
        return bottleService.addBottle(request,response);
    }

    //----------------------Edit/Update

    @RequestMapping(value="/updateBottle", method = RequestMethod.POST)
    public ModelAndView updateBottle(HttpServletRequest request, HttpServletResponse response, ModelMap map){
        ModelAndView view = new ModelAndView("inventory-bottles");

        String bottle_id = request.getParameter("bottle_id");
        String status = request.getParameter("status");

        System.out.println("BOTTLE ID: " + bottle_id + "\nSTATUS: " + status);
        return view;
    }
}
