package com.livingwater.services.impl;

import com.livingwater.dao.BatchBottlesDao;
import com.livingwater.dao.BatchDao;
import com.livingwater.dao.BottleDao;
import com.livingwater.entities.*;
import com.livingwater.services.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {

            view = new ModelAndView("inventory-batch");

            Batch batch = new Batch();
            batchDao.create(batch);
            view.addObject("batchList", batchDao.getAllBatch());
            view.addObject("allBottlesList", bottleDao.getAllBottle());
        }
        return view;
    }


    public ModelAndView addBottleToBatch(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {

            view = new ModelAndView("inventory-batch");

            int batch_id = Integer.parseInt(request.getParameter("batch_id"));
            String bottle_id = request.getParameter("bottle_id");

            if (!batchBottlesDao.isBatchBottlesInDB(batch_id, bottle_id)) {
                Bottle bottle = bottleDao.getABottle(bottle_id);
                BatchBottles batchBottles = new BatchBottles(batch_id, bottle);

                batchBottlesDao.create(batchBottles);
            }
        }

        return view;

    }

    public ModelAndView getBatches(HttpServletRequest request) {
        ModelAndView view;

        User user1 = (User) request.getSession().getAttribute("session_login_user");

        if (user1 == null) {

            view = new ModelAndView("login");
        } else {

            view = new ModelAndView("inventory-batch");
            List<Batch> batchList = batchDao.getAllBatch();
            view.addObject("batchList", batchList);
            view.addObject("allBottlesList", bottleDao.getAllBottle());
        }

        return view;


    }

    public List<Batch> getAllBatch() {
        List<Batch> batchList = batchDao.getAllBatch();

        return batchList;
    }

    public Batch getBatch(int id) {
        Batch batch = batchDao.getBatch(id);

        return batch;
    }


    private List<Batch> getBatch() {
        return batchDao.getAllBatch();
    }


}
