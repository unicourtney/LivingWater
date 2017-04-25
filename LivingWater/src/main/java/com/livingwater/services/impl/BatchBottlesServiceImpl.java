package com.livingwater.services.impl;

import com.livingwater.dao.BatchBottlesDao;
import com.livingwater.dao.BatchDao;
import com.livingwater.dao.BottleDao;
import com.livingwater.entities.BatchBottles;
import com.livingwater.entities.Bottle;
import com.livingwater.services.BatchBottlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by CourtneyLove on 4/20/2017.
 */

@Service("batchBottlesService")
@Transactional
public class BatchBottlesServiceImpl implements BatchBottlesService{

    @Autowired
    private BatchBottlesDao batchBottlesDao;

    @Autowired
    private BottleDao bottleDao;

    @Autowired
    private BatchDao batchDao;

    public BatchBottles getLastRecord() {

        BatchBottles batchBottles = batchBottlesDao.getLastRecord();

        return batchBottles;
    }



    public ModelAndView addBatchBottles(HttpServletRequest req, HttpServletResponse res) {
        ModelAndView mav = new ModelAndView("inventory-batch");
        int batchID = Integer.parseInt(req.getParameter("batch_id"));
        int bottleID = Integer.parseInt(req.getParameter("bottle_id"));


        if(batchBottlesDao.isBatchBottlesInDB(batchID,req.getParameter("bottle_id"))){
            System.out.println("bottle already exists in batch");
            mav.addObject("batchList",batchDao.getAllBatch());
            mav.addObject("allBottlesList",bottleDao.getAllBottle());
            return mav;
        }
        else{
            BatchBottles batchBottles = new BatchBottles(Calendar.getInstance(),batchDao.getABatch(batchID),bottleDao.getABottle(req.getParameter("bottle_id")));
             batchBottlesDao.create(batchBottles);
            System.out.println("Successfully Inserted");
            mav.addObject("batchList",batchDao.getAllBatch());
            mav.addObject("allBottlesList",bottleDao.getAllBottle());
            return mav;
        }
    }

    public ModelAndView getAllBottlesInBatch(int batchID) {
        ModelAndView mav = new ModelAndView("inventory-batch");
        List<BatchBottles> batchBottles = batchBottlesDao.getAllBottles(batchID);
        List<Bottle> bottles = new ArrayList<Bottle>();
        for(int x  =0;x<batchBottles.size();x++){
            bottles.add(bottleDao.getABottle(batchBottles.get(x).getBottle().getSerialNumber()));
            System.out.println(bottles.get(x));
        }
        mav.addObject("batchSelected",batchID);
        mav.addObject("batchList",batchDao.getAllBatch());
        mav.addObject("allBottlesList",bottleDao.getAllBottle());
        mav.addObject("bottlesList",bottles);
        return  mav;
    }


}
