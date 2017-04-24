package com.livingwater.services.impl;

import com.livingwater.dao.CustomerDao;
import com.livingwater.entities.Customer;
import com.livingwater.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

        Customer customer = new Customer();
        customer.setAddress(customer_address);
        customer.setContactNumber(customer_contact);
        customer.setName(customer_name);
        customer.setTypeOfCustomer(customer_type);

        customerDao.create(customer);

        List<Customer> customerList = customerDao.getAllCustomer();

        view.addObject("customerList", customerList);
        return view;
    }

    public List<Customer> getAllCustomer() {

        List<Customer> customerList = customerDao.getAllCustomer();

        return customerList;
    }

    public Customer getCustomer(int id) {

        Customer customer = customerDao.getCustomer(id);

        return customer;
    }

    public ModelAndView updateCustomer(int id, HttpServletRequest request, HttpServletResponse response) {

        ModelAndView view = new ModelAndView("customer-info");

        String customer_name = request.getParameter("customer_name");
        String customer_address = request.getParameter("customer_address");
        Long customer_contact = Long.parseLong(request.getParameter("customer_contact"));
        String customer_type = request.getParameter("customer_type");


        Customer customer = new Customer();
        customer.setCustomerID(id);
        customer.setAddress(customer_address);
        customer.setContactNumber(customer_contact);
        customer.setName(customer_name);
        customer.setTypeOfCustomer(customer_type);

        customerDao.update(customer);
        customer = customerDao.getCustomer(id);

        view.addObject("customer", customer);
        return view;
    }

    @RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.POST)
    public ModelAndView deleteCustomer(int id) {

        ModelAndView view = new ModelAndView("customer-profiles");

        Customer customer = customerDao.getCustomer(id);

        customerDao.delete(customer);

        List<Customer> customerList = customerDao.getAllCustomer();
        view.addObject("customerList", customerList);

        return view;
    }
}
