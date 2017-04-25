package com.livingwater.services.impl;

import com.livingwater.dao.BatchBottlesDao;
import com.livingwater.entities.BatchBottles;
import com.livingwater.entities.Bottle;
import com.livingwater.services.BatchBottlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by CourtneyLove on 4/20/2017.
 */

@Service("batchBottlesService")
@Transactional
public class BatchBottlesServiceImpl implements BatchBottlesService{

    @Autowired
    private BatchBottlesDao batchBottlesDao;


}
