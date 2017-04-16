package com.livingwater.services;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by John Leeroy Gadiane on 16/04/2017.
 */
public interface EmployeeService {
    public ModelAndView addEmployee(HttpServletRequest request, HttpServletResponse response);
}
