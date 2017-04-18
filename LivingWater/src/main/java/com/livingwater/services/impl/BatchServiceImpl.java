package com.livingwater.services.impl;

import com.livingwater.dao.BatchBottlesDao;
import com.livingwater.dao.BatchDao;
import com.livingwater.dao.BottleDao;
import com.livingwater.entities.Batch;
import com.livingwater.entities.BatchBottles;
import com.livingwater.entities.Bottle;
import com.livingwater.services.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by John Leeroy Gadiane on 16/04/2017.
 */
@Service("batchService")
@Transactional
public class BatchServiceImpl implements BatchService {

    @Autowired
    private BatchDao batchDao;

    @Autowired
    private BottleDao bottleDao;

    @Autowired
    private BatchBottlesDao batchBottlesDao;

    public ModelAndView addBatch(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView("inventory-batch");

        Batch batch = new Batch();
        batchDao.create(batch);
        return view;
    }

    public ModelAndView addBottleToBatch(HttpServletRequest request, HttpServletResponse response){
        ModelAndView view = new ModelAndView("inventory-batch");

        int batch_id = Integer.parseInt(request.getParameter("batch_id"));
        int bottle_id = Integer.parseInt(request.getParameter("bottle_id"));

        if(!batchBottlesDao.isBatchBottlesInDB(batch_id, bottle_id)){
            Bottle bottle = bottleDao.getABottle(bottle_id);
            BatchBottles batchBottles = new BatchBottles(batch_id,bottle);

            batchBottlesDao.create(batchBottles);
        }


        return view;

    }

}
