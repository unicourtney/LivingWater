package com.livingwater.services.impl;

import com.livingwater.dao.TransactionBottlesDao;
import com.livingwater.dao.TransactionDao;
import com.livingwater.entities.Bottle;
import com.livingwater.entities.Customer;
import com.livingwater.entities.Transaction;
import com.livingwater.entities.TransactionBottles;
import com.livingwater.services.CustomerService;
import com.livingwater.services.TransactionBottlesService;
import com.livingwater.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
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


    public ModelAndView createTransaction(Integer id, HttpServletRequest request, HttpServletResponse response) throws ParseException {
        ModelAndView view = new ModelAndView("customer-transaction-bottles");

        Customer customer = customerService.getCustomer(id);

        String bottle_case = request.getParameter("bottle_case");
        Double transaction_price = Double.parseDouble(String.valueOf(request.getParameter("transaction_price")));
        String transaction_date = request.getParameter("transaction_date");

        request.getSession().setAttribute("session_customer_name", customer.getName());
        request.getSession().setAttribute("session_customer_id", customer.getCustomerID());
        request.getSession().setAttribute("session_bottle_case", bottle_case);
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

        return view;
    }

    public ModelAndView cancelTransaction(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView("customer-transaction");

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
        return view;
    }

    public List<Transaction> getAllTransaction(){
        List<Transaction> transactionList = transactionDao.getAllTransaction();

        return transactionList;
    }
}
