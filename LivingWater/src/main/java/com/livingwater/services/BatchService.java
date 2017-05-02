package com.livingwater.services;

import com.livingwater.entities.BatchBottles;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by John Leeroy Gadiane on 16/04/2017.
 */
public interface BatchService {

    public ModelAndView addBatch(HttpServletRequest request, HttpServletResponse response);
    ModelAndView getBatches();

}
