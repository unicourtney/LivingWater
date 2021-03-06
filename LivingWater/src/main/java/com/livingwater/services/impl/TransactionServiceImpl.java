package com.livingwater.services.impl;

import com.livingwater.dao.TransactionDao;
import com.livingwater.entities.*;
import com.livingwater.services.CustomerService;
import com.livingwater.services.TransactionBottlesService;
import com.livingwater.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by CourtneyLove on 4/20/2017.
 */
@Service("transactionService")
@Transactional
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private TransactionBottlesService transactionBottlesService;

    public ModelAndView createTransaction(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {


            Double transaction_price = Double.parseDouble(String.valueOf(request.getParameter("transaction_price")));
            String transaction_date = request.getParameter("transaction_date");
            Integer customer_id = Integer.parseInt(request.getParameter("customer_id"));

            Customer customer = customerService.getCustomer(customer_id);

            if (customer != null) {
                view = new ModelAndView("transaction-bottles");

                request.getSession().setAttribute("session_customer_name", customer.getName());
                request.getSession().setAttribute("session_customer_id", customer.getCustomerID());
                request.getSession().setAttribute("session_transaction_price", transaction_price);
                request.getSession().setAttribute("session_transaction_date", transaction_date);

                DateFormat transactionDateFormat = new SimpleDateFormat("MM/dd/yyyy");
                Date date = transactionDateFormat.parse(transaction_date);
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                Transaction transaction = new Transaction();
                TransactionBottles transactionBottles = new TransactionBottles();

                transaction.setCustomer(customer);
                transaction.setDateOfDelivery(sqlDate);
                transactionDao.create(transaction);

                Transaction transaction1 = transactionDao.getLastRecord();

                request.getSession().setAttribute("session_transaction_id", transaction1.getTransactionID());
            } else {

                view = new ModelAndView("transaction");

                view.addObject("transaction_error_message", "Invalid customer ID.");
            }
        }
        return view;
    }

    public ModelAndView cancelTransaction(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {

            view = new ModelAndView("transaction");

            int transaction_id = Integer.parseInt(String.valueOf(request.getSession().getAttribute("session_transaction_id")).trim());

            if (transaction_id != 0) {
                Transaction transaction = transactionDao.getTransaction(transaction_id);
                System.out.append("TRANSACTION ID NI MAYORA: ---------------- " + transaction.getTransactionID());
                transactionDao.delete(transaction);
                request.getSession().removeAttribute("session_transaction_id");
            }
            int customer_id = Integer.parseInt(String.valueOf(request.getSession().getAttribute("session_customer_id")).trim());

            Customer customer = customerService.getCustomer(customer_id);

            view.addObject("customer", customer);
        }
        return view;
    }

    public List<Transaction> getAllTransaction() {
        List<Transaction> transactionList = transactionDao.getAllTransaction();

        return transactionList;
    }

    public Transaction getTransaction(int id) {
        Transaction transaction = transactionDao.getTransaction(id);

        return transaction;
    }

    public ModelAndView confirmTransaction(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {

            view = new ModelAndView("customer-profiles");

            Integer transaction_id = Integer.parseInt(String.valueOf(request.getSession().getAttribute("session_transaction_id")));
            Double transaction_price = Double.parseDouble(String.valueOf(request.getSession().getAttribute("session_transaction_price")));
            Transaction transaction = transactionDao.getTransaction(transaction_id);

            List<TransactionBottles> transactionBottlesList = transactionBottlesService.getAllBottlesWithATransactionIDLike(transaction_id);

            Double totalCost = transaction_price * transactionBottlesList.size();
            transaction.setTotalCost(totalCost);
            transaction.setNumberOfBottles(transactionBottlesList.size());
            transactionDao.update(transaction);

            request.getSession().removeAttribute("session_customer_name");
            request.getSession().removeAttribute("session_customer_id");
            request.getSession().removeAttribute("session_bottle_case");
            request.getSession().removeAttribute("session_transaction_price");
            request.getSession().removeAttribute("session_transaction_date");
            request.getSession().removeAttribute("session_transaction_id");

            List<Customer> customerList = customerService.getAllCustomer();

            view.addObject("customerList", customerList);
        }

        return view;
    }

    public List<Transaction> getCustomerTransaction(int id) {

        List<Transaction> transactionList = transactionDao.getCustomerTransaction(id);

        return transactionList;
    }

    public Transaction getBottlesOnHand(int id) {

        Transaction transaction = transactionDao.getBottlesOnHand(id);

        return transaction;
    }

    public Transaction getBottlesReturned(int id){

        Transaction transaction = transactionDao.getBottlesReturned(id);

        return  transaction;
    }
}
