package com.livingwater.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.livingwater.entities.*;
import com.livingwater.services.CustomerService;
import com.livingwater.services.TransactionBottlesService;
import com.livingwater.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.primitives.Ints.max;


/**
 * Created by CourtneyLove on 4/14/2017.
 */

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionBottlesService transactionBottlesService;

    @RequestMapping(value = "demo2/{customerID}", method = RequestMethod.GET)
    @ResponseBody
    public String demo2(@PathVariable("customerID") String customerID) {

        int id = Integer.parseInt(customerID);

        Transaction transactionBottlesOnHand = transactionService.getBottlesOnHand(id);
        Transaction transactionBottlesReturned = transactionService.getBottlesReturned(id);
        List<TransactionBottles> bottlesOnHandList = transactionBottlesService.getBottlesOnHand(transactionBottlesOnHand.getTransactionID());

        List<CustomerBottles> customerBottlesList = new ArrayList<CustomerBottles>();

//        System.out.println("---------------" + transactionBottlesOnHand.getTransactionID() + " | " + transactionBottlesReturned.getTransactionID());

        System.out.println("ON HAND: " + bottlesOnHandList.size());
        CustomerBottles customerBottles = null;

        if (transactionBottlesReturned != null) {
            List<TransactionBottles> bottlesReturnedList = transactionBottlesService.getBottlesReturned(transactionBottlesReturned.getTransactionID());
            for (int a = 0; a < max(bottlesOnHandList.size(), bottlesReturnedList.size()); a++) {
                customerBottles = new CustomerBottles();
                if (a  < bottlesOnHandList.size() && a  < bottlesReturnedList.size()) {
                    customerBottles.setBottlesOnHand(bottlesOnHandList.get(a ).getBottle().getSerialNumber());
                    customerBottles.setBottlesReturned(bottlesReturnedList.get(a ).getBottle().getSerialNumber());
                } else if (a  < bottlesReturnedList.size()) {

                    if (bottlesReturnedList.get(a ) != null) {
                        customerBottles.setBottlesReturned(bottlesReturnedList.get(a ).getBottle().getSerialNumber());

                    } else {
                        customerBottles.setBottlesReturned("0");
                    }
                } else {

                    if (bottlesOnHandList.get(a ) != null) {
                        customerBottles.setBottlesOnHand(bottlesOnHandList.get(a ).getBottle().getSerialNumber());

                    } else {
                        customerBottles.setBottlesOnHand("0");
                    }
                }

                customerBottlesList.add(customerBottles);
            }

        }else{

            for(TransactionBottles b : bottlesOnHandList){

                customerBottles = new CustomerBottles();

                customerBottles.setBottlesOnHand(b.getBottle().getSerialNumber());

                customerBottlesList.add(customerBottles);
            }
        }
        Gson gson = new Gson();
        String json = gson.toJson(customerBottlesList);
        return json;
    }

    @RequestMapping(value = "/profiles/customers", method = RequestMethod.GET)
    public ModelAndView customerProfilesPage(HttpServletRequest request) {
        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {

            view = new ModelAndView("customer-profiles");

            List<Customer> customerList = customerService.getAllCustomer();

            view.addObject("customerList", customerList);
        }
        return view;
    }

    @RequestMapping(value = "/profiles/customers/info/{id}", method = RequestMethod.GET)
    public ModelAndView customerInfoPage(@PathVariable("id") Integer id, HttpServletRequest request) {
        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {

            view = new ModelAndView("customer-info");

            Customer customer = customerService.getCustomer(id);

            List<Transaction> transactionList = transactionService.getCustomerTransaction(id);

            view.addObject("customer", customer);
            view.addObject("transactionList", transactionList);
        }
        return view;
    }

    //----------------------Add

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public ModelAndView addCustomer(HttpServletRequest request, HttpServletResponse response) {
        return customerService.addCustomer(request, response);
    }

    //----------------------Edit

    @RequestMapping(value = "/editCustomer/{id}", method = RequestMethod.POST)
    public ModelAndView editCustomer(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) {


        return customerService.updateCustomer(id, request, response);
    }

    //----------------------Delete

    @RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.GET)
    public ModelAndView deleteCustomer(@PathVariable("id") Integer id, HttpServletRequest request) {

        return customerService.deleteCustomer(id, request);
    }


}
