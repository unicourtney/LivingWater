package com.livingwater.controllers;

import com.livingwater.entities.Customer;
import com.livingwater.services.CustomerService;
import com.livingwater.services.TransactionBottlesService;
import com.livingwater.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


    @RequestMapping(value = "/profiles/customers/transaction/{id}", method = RequestMethod.GET)
    public ModelAndView deliveryPage(@PathVariable("id") Integer id) {
        ModelAndView view = new ModelAndView("customer-transaction");

        Customer customer = customerService.getCustomer(id);

        view.addObject("customer", customer);
        return view;
    }

    //----------------------Add

    @RequestMapping(value = "/createTransaction/{id}", method = RequestMethod.POST)
    public ModelAndView createTransaction(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) throws ParseException {

        return transactionService.createTransaction(id, request, response);
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
}
