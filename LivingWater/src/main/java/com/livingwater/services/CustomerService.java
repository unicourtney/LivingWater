package com.livingwater.services;

import com.livingwater.entities.Customer;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by John Leeroy Gadiane on 16/04/2017.
 */
public interface CustomerService {

    public ModelAndView addCustomer(HttpServletRequest request, HttpServletResponse response);

    public List<Customer> getAllCustomer();

    public Customer getCustomer(int id);

    public ModelAndView updateCustomer(int id, HttpServletRequest request, HttpServletResponse response);

    public ModelAndView deleteCustomer(int id, HttpServletRequest request);


}
