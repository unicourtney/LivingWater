package com.livingwater.controllers;

import com.livingwater.services.SuppliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by CourtneyLove on 4/16/2017.
 */
@Controller
public class SupplyController {

    //----------------------Add
    @Autowired
    private SuppliesService suppliesService;


    @RequestMapping(value = "/addSupply", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        return suppliesService.addSupply(request,response);
    }
}
