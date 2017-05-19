package com.livingwater.services;

import com.livingwater.entities.TransactionBottles;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by CourtneyLove on 4/21/2017.
 */
public interface TransactionBottlesService {

    List<TransactionBottles> getAllBottlesWithATransactionIDLike(int transaction_id);

    ModelAndView addTransactionBottles(HttpServletRequest request, HttpServletResponse response);

    ModelAndView deleteTransactionBottles(Integer id, HttpServletRequest request, HttpServletResponse response);

    ModelAndView cancelTransactionBottle(HttpServletRequest request, HttpServletResponse response);

    public List<TransactionBottles> getBottlesReturned(int id);

    public List<TransactionBottles> getBottlesOnHand(int id);
}
