package com.livingwater.services;

import com.livingwater.entities.Dispenser;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by CourtneyLove on 4/23/2017.
 */
public interface DispenserService {

    public ModelAndView addDispenser(HttpServletRequest request, HttpServletResponse response);

    public List<Dispenser> getAllDispenserFromCustomer(int id);

    public ModelAndView deleteDispenser(Integer id, HttpServletRequest request, HttpServletResponse response);
}
