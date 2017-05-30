package com.livingwater.services;

import com.livingwater.entities.Delivery;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by CourtneyLove on 4/24/2017.
 */
public interface DeliveryService {

    public ModelAndView createDelivery(HttpServletRequest request, HttpServletResponse response);

    public List<Delivery> getAllDelivery();
}
