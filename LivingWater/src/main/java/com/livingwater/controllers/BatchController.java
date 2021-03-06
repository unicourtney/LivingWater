package com.livingwater.controllers;

import com.livingwater.entities.BatchBottles;
import com.livingwater.services.BatchBottlesService;
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

    @Autowired
    private BatchBottlesService batchBottlesService;
    //----------------------Add

    @RequestMapping(value = "/addBatch", method = RequestMethod.POST)
    public ModelAndView addBatch(HttpServletRequest request, HttpServletResponse response) {

        return batchService.addBatch(request, response);
    }

    @RequestMapping(value = "/addBottleToBatch", method = RequestMethod.POST)

    public ModelAndView addBottleToBatch(HttpServletRequest request, HttpServletResponse response) {
        return batchBottlesService.addBatchBottles(request, response);
    }


    @RequestMapping(value = "/inventory/batch", method = RequestMethod.GET)
    public ModelAndView inventoryBatchPage(HttpServletRequest request) {

        return batchService.getBatches(request);
    }

    @RequestMapping(value = "/inventory/getBatch", method = RequestMethod.POST)
    public ModelAndView getInventoryBatch(HttpServletRequest req, HttpServletResponse resp) {
        return batchBottlesService.getAllBottlesInBatch(Integer.parseInt(req.getParameter("showBatchID")), req);
    }

}
