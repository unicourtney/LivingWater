package com.livingwater.services;

import com.livingwater.entities.Bottle;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
public interface BottleService {

    public ModelAndView addBottle(HttpServletRequest request, HttpServletResponse response);

    public Bottle getABottle(String id);

    ModelAndView updateBottle(HttpServletRequest request, HttpServletResponse response);


}
