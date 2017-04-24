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

    public List<TransactionBottles> getAllBottlesWithATransactionIDLike(String transaction_id);

    public ModelAndView addTransactionBottles(HttpServletRequest request, HttpServletResponse response);

    public ModelAndView deleteTransactionBottles(Integer id, HttpServletRequest request, HttpServletResponse response);

}
