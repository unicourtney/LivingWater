package com.livingwater.services.impl;

import com.livingwater.dao.BatchDao;
import com.livingwater.entities.Batch;
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

    public ModelAndView addBatch(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView("inventory-batch");

        Integer batch_id = Integer.parseInt(request.getParameter("batch_id"));

        Batch batch = new Batch();
        batch.setBatchID(batch_id);
        batchDao.create(batch);
        return view;
    }
}
