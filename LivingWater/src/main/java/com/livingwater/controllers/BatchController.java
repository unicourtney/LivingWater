package com.livingwater.controllers;

import com.livingwater.services.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by John Leeroy Gadiane on 16/04/2017.
 */

@Controller
public class BatchController {

    @Autowired
    private BatchService batchService;

    //----------------------Add

    @RequestMapping(value="/addBatch", method = RequestMethod.POST)
    public ModelAndView addBatch(HttpServletRequest request, HttpServletResponse response, ModelMap map){
        return batchService.addBatch(request,response);
    }

    @RequestMapping(value="/addBottleToBatch", method = RequestMethod.POST)
    public ModelAndView addBottleToBatch(HttpServletRequest request, HttpServletResponse response, ModelMap map){
        ModelAndView view = new ModelAndView("inventory-batch");

        String batch_id = request.getParameter("batch_id");
        String bottle_id = request.getParameter("bottle_id");

        System.out.println("BATCH ID: " + batch_id + "\nBOTTLE ID: " + bottle_id);
        return view;
    }
}
