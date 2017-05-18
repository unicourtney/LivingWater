package com.livingwater.services;

import com.livingwater.entities.Transaction;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;

/**
 * Created by CourtneyLove on 4/20/2017.
 */
public interface TransactionService {

    public ModelAndView createTransaction(HttpServletRequest request, HttpServletResponse response) throws  ParseException;

    public ModelAndView cancelTransaction(HttpServletRequest request, HttpServletResponse response);

    public Transaction getTransaction(int id);

    public ModelAndView confirmTransaction(HttpServletRequest request, HttpServletResponse response);

    public List<Transaction> getCustomerTransaction(int id);

    public Transaction getBottlesOnHand(int id);

    public Transaction getBottlesReturned(int id);
}
