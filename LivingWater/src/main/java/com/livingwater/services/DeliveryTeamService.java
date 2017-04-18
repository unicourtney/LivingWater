package com.livingwater.services;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by John Leeroy Gadiane on 19/04/2017.
 */
public interface DeliveryTeamService {

    public ModelAndView addDeliveryTeam(HttpServletRequest request, HttpServletResponse response);

}
