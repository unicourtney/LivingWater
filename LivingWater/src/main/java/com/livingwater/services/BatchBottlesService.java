package com.livingwater.services;

import com.livingwater.entities.BatchBottles;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by CourtneyLove on 4/20/2017.
 */
public interface BatchBottlesService {


    ModelAndView addBatchBottles(HttpServletRequest req, HttpServletResponse res);

    ModelAndView getAllBottlesInBatch(int batchID, HttpServletRequest request);

}
