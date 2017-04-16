package com.livingwater.services.impl;

import com.livingwater.dao.CustomerDao;
import com.livingwater.entities.Customer;
import com.livingwater.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by John Leeroy Gadiane on 16/04/2017.
 */
@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public ModelAndView addCustomer(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView("customer-profiles");

        String customer_name = request.getParameter("customer_name");
        String customer_address = request.getParameter("customer_address");
        Long customer_contact = Long.parseLong(request.getParameter("customer_contact"));
        String customer_type = request.getParameter("customer_type");
        Double customer_pricing = Double.parseDouble(request.getParameter("customer_pricing"));

        Customer customer = new Customer();
        customer.setAddress(customer_address);
        customer.setContactNumber(customer_contact);
        customer.setName(customer_name);
        customer.setPricing(customer_pricing);
        customer.setTypeOfCustomer(customer_type);

        customerDao.create(customer);

        return view;
    }
}
