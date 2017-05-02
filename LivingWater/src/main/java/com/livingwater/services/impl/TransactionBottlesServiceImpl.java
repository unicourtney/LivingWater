package com.livingwater.services.impl;

import com.livingwater.dao.TransactionBottlesDao;
import com.livingwater.entities.Bottle;
import com.livingwater.entities.Transaction;
import com.livingwater.entities.TransactionBottles;
import com.livingwater.services.TransactionBottlesService;
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

    public List<TransactionBottles> getAllBottlesWithATransactionIDLike(int transaction_id) {
        List<TransactionBottles> transactionBottlesList = transactionBottlesDao.getAllBottlesWithATransactionIDLike(transaction_id);

        return transactionBottlesList;
    }

    public ModelAndView addTransactionBottles(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView("customer-transaction-bottles");

        Integer transaction_id = Integer.parseInt(String.valueOf(request.getSession().getAttribute("session_transaction_id")));
//        String bottle_case = String.valueOf(request.getSession().getAttribute("session_bottle_case"));
        Double transaction_price = Double.parseDouble(String.valueOf(request.getSession().getAttribute("session_transaction_price")));
        String bottle_id = request.getParameter("bottle_id");

        Transaction transaction = new Transaction();
        transaction.setTransactionID(transaction_id);

        Bottle bottle = new Bottle();
        bottle.setSerialNumber(bottle_id);
        TransactionBottles transactionBottles = new TransactionBottles();
        transactionBottles.setTransaction(transaction);
        transactionBottles.setBottle(bottle);

        transactionBottlesDao.create(transactionBottles);

      /*  List<TransactionBottles> transactionBottlesList = transactionBottlesDao.getAllBottlesWithATransactionIDLike(String.valueOf(transaction_id));

        view.addObject("transactionBottlesList", transactionBottlesList);*/

        return view;
    }

    public ModelAndView deleteTransactionBottles(Integer id, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView("customer-transaction-bottles");

        String transaction_id = String.valueOf(request.getSession().getAttribute("session_transaction_id"));

        Transaction transaction = new Transaction();
        transaction.setTransactionID(Integer.parseInt(transaction_id));

        Bottle bottle = new Bottle();
        bottle.setSerialNumber(String.valueOf(id));

        TransactionBottles transactionBottles = new TransactionBottles(transaction, bottle);

        transactionBottlesDao.delete(transactionBottles);

        List<TransactionBottles> transactionBottlesList = transactionBottlesDao.getAllBottlesWithATransactionIDLike(Integer.parseInt(transaction_id));

        view.addObject("transactionBottlesList", transactionBottlesList);

        return view;
    }
}
