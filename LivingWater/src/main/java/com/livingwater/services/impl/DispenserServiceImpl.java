package com.livingwater.services.impl;

import com.livingwater.dao.CustomerDao;
import com.livingwater.dao.DispenserDao;
import com.livingwater.entities.Customer;
import com.livingwater.entities.Dispenser;
import com.livingwater.entities.User;
import com.livingwater.services.DispenserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by CourtneyLove on 4/23/2017.
 */

@Service("dispenserService")
@Transactional
public class DispenserServiceImpl implements DispenserService {

    @Autowired
    private DispenserDao dispenserDao;

    @Autowired
    private CustomerDao customerDao;

    public ModelAndView addDispenser(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {

            view = new ModelAndView("customer-dispensers");

            String dispenser_id = request.getParameter("dispenser_id");
            int customer_id = Integer.parseInt(request.getParameter("customer_id").trim());

            Customer customer = customerDao.getCustomer(customer_id);

            Dispenser dispenser = new Dispenser();

            dispenser.setSerialNumber(dispenser_id);
            dispenser.setCustomer(customer);

            dispenserDao.create(dispenser);

            System.out.println("---------------CREATE DISPENSER");

            List<Dispenser> dispenserList = getAllDispenserFromCustomer(customer_id);

            if (dispenserList != null) {
                view.addObject("dispenserList", dispenserList);
            }
            view.addObject("customer", customer);
        }

        return view;
    }

    public List<Dispenser> getAllDispenserFromCustomer(int id) {
        List<Dispenser> dispenserList = dispenserDao.getAllDispenserFromCustomer(id);

        return dispenserList;
    }

    public ModelAndView deleteDispenser(Integer id, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {

            view = new ModelAndView("customer-dispensers");

            Integer customer_id = Integer.parseInt(String.valueOf(request.getSession().getAttribute("session_customer_id")));

            Dispenser dispenser = new Dispenser();
            dispenser.setSerialNumber(String.valueOf(id));
            dispenserDao.delete(dispenser);

            List<Dispenser> dispenserList = getAllDispenserFromCustomer(customer_id);

            if (dispenserList != null) {
                view.addObject("dispenserList", dispenserList);
            }
        }

        return view;
    }
}
