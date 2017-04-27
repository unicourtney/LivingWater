package com.livingwater.services;

import com.livingwater.entities.DeliveryTeam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by John Leeroy Gadiane on 19/04/2017.
 */
public interface DeliveryTeamService {

    public ModelAndView addUserToTeam(HttpServletRequest request, HttpServletResponse response);

    public List<DeliveryTeam> getAllDeliveryTeam();

}
