package com.livingwater.services.impl;

import com.livingwater.dao.BatchDao;
import com.livingwater.dao.DeliveryDao;
import com.livingwater.entities.Batch;
import com.livingwater.entities.Delivery;
import com.livingwater.services.BatchService;
import com.livingwater.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by CourtneyLove on 4/24/2017.
 */

@Service("deliveryService")
@Transactional
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private BatchService batchService;

    @Autowired
    private BatchDao batchDao;

    @Autowired
    private DeliveryDao deliveryDao;

    public ModelAndView createDelivery(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView("inventory-delivery");

        Delivery delivery = new Delivery();
        delivery.setStatus("Okay");
        deliveryDao.create(delivery);

        /*List<Batch> batchList = batchDao.getAllBatch();

        view.addObject("batchList", batchList);*/
        return view;
    }

    public List<Delivery> getAllDelivery() {
        List<Delivery> deliveryList = deliveryDao.getAllDelivery();

        return deliveryList;
    }
}