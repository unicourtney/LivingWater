package com.livingwater.controllers;

import com.google.gson.Gson;
import com.livingwater.dao.CustomerDao;
import com.livingwater.entities.Customer;
import com.livingwater.entities.User;
import com.livingwater.services.CustomerService;
import com.livingwater.services.TransactionBottlesService;
import com.livingwater.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;

/**
 * Created by CourtneyLove on 4/18/2017.
 */
@Controller
public class TransactionController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionBottlesService transactionBottlesService;

    @Autowired
    private CustomerDao customerDao;


    @RequestMapping(value = "/profiles/customers/transaction/{id}", method = RequestMethod.GET)
    public ModelAndView deliveryPage(@PathVariable("id") Integer id, HttpServletRequest request) {
        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {

            view = new ModelAndView("customer-transaction");

            Customer customer = customerService.getCustomer(id);

            view.addObject("customer", customer);
        }
        return view;
    }

    //----------------------Add

    @RequestMapping(value = "/createTransaction", method = RequestMethod.POST)
    public ModelAndView createTransaction(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        return transactionService.createTransaction(request, response);
    }

    @RequestMapping(value = "/addTransactionBottles", method = RequestMethod.POST)
    public ModelAndView addTransactionBottles(HttpServletRequest request, HttpServletResponse response) {

        return transactionBottlesService.addTransactionBottles(request, response);
    }

    //----------------------Update

    @RequestMapping(value = "/confirmTransaction", method = RequestMethod.POST)
    public ModelAndView confirmTransaction(HttpServletRequest request, HttpServletResponse response) {

        return transactionService.confirmTransaction(request, response);
    }

    //----------------------Delete

    @RequestMapping(value = "/deleteTransactionBottle/{id}", method = RequestMethod.GET)
    public ModelAndView deleteTransactionBottles(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) throws ParseException {

        return transactionBottlesService.deleteTransactionBottles(id, request, response);
    }

    @RequestMapping(value = "/cancelTransaction", method = RequestMethod.GET)
    public ModelAndView cancelTransaction(HttpServletRequest request, HttpServletResponse response) {

        return transactionService.cancelTransaction(request, response);
    }

    @RequestMapping(value = "/cancelTransactionBottle", method = RequestMethod.GET)
    public ModelAndView cancelTransactionBottle(HttpServletRequest request, HttpServletResponse response) {

        return transactionBottlesService.cancelTransactionBottle(request, response);

    }


    @RequestMapping(value = "/getPrice/{customerID}", method = RequestMethod.GET)
    @ResponseBody
    public String getPrice(@PathVariable("customerID") String customerID) {
        int id = Integer.parseInt(customerID);
        Customer customer = customerDao.getCustomer(id);

        Gson gson = new Gson();
        String json = gson.toJson(customer);

        return json;
    }
}
