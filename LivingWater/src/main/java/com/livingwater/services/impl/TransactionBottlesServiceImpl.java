package com.livingwater.services.impl;

import com.livingwater.dao.TransactionBottlesDao;
import com.livingwater.dao.TransactionDao;
import com.livingwater.entities.*;
import com.livingwater.services.BottleService;
import com.livingwater.services.CustomerService;
import com.livingwater.services.TransactionBottlesService;
import com.livingwater.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by CourtneyLove on 4/21/2017.
 */
@Service("transactionBottlesService")
@Transactional
public class TransactionBottlesServiceImpl implements TransactionBottlesService {

    @Autowired
    private TransactionBottlesDao transactionBottlesDao;

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private BottleService bottleService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CustomerService customerService;

    public List<TransactionBottles> getAllBottlesWithATransactionIDLike(int transaction_id) {
        List<TransactionBottles> transactionBottlesList = transactionBottlesDao.getAllBottlesWithATransactionIDLike(transaction_id);

        return transactionBottlesList;
    }

    public ModelAndView addTransactionBottles(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {

            view = new ModelAndView("customer-transaction-bottles");

            Integer transaction_id = Integer.parseInt(String.valueOf(request.getSession().getAttribute("session_transaction_id")));
//        String bottle_case = String.valueOf(request.getSession().getAttribute("session_bottle_case"));
            Double transaction_price = Double.parseDouble(String.valueOf(request.getSession().getAttribute("session_transaction_price")));
            String bottle_id = request.getParameter("bottle_id");

            Transaction transaction = transactionService.getTransaction(transaction_id);
            Bottle bottle = bottleService.getABottle(bottle_id);
            TransactionBottles transactionBottles = new TransactionBottles();
            transactionBottles.setTransaction(transaction);
            transactionBottles.setBottle(bottle);

            transactionBottlesDao.create(transactionBottles);

            List<TransactionBottles> transactionBottlesList = transactionBottlesDao.getAllBottlesWithATransactionIDLike(transaction_id);

            view.addObject("transactionBottlesList", transactionBottlesList);
        }

        return view;
    }

    public ModelAndView deleteTransactionBottles(Integer id, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {

            view = new ModelAndView("customer-transaction-bottles");

            Integer transaction_id = Integer.parseInt(String.valueOf(request.getSession().getAttribute("session_transaction_id")));

            Transaction transaction = transactionService.getTransaction(transaction_id);

            Bottle bottle = bottleService.getABottle(String.valueOf(id));

            TransactionBottles transactionBottles = new TransactionBottles(transaction, bottle);

            transactionBottlesDao.delete(transactionBottles);

            List<TransactionBottles> transactionBottlesList = transactionBottlesDao.getAllBottlesWithATransactionIDLike(transaction_id);

            view.addObject("transactionBottlesList", transactionBottlesList);
        }


        return view;
    }

    public ModelAndView cancelTransactionBottle(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {

            view = new ModelAndView("customer-transaction");

            Integer id = Integer.parseInt(String.valueOf(request.getSession().getAttribute("session_customer_id")));

            Customer customer = customerService.getCustomer(id);

            Integer transaction_id = Integer.parseInt(String.valueOf(request.getSession().getAttribute("session_transaction_id")));
            List<TransactionBottles> transactionBottlesList = getAllBottlesWithATransactionIDLike(transaction_id);

            Transaction transaction = transactionService.getTransaction(transaction_id);

            for(TransactionBottles a :  transactionBottlesList){

                transactionBottlesDao.delete(a);
            }

            transactionDao.delete(transaction);

            view.addObject("customer", customer);
        }

        return view;
    }
    
}
