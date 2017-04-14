package com.livingwater.dao.impl;

import com.livingwater.dao.BatchBottlesDao;
import com.livingwater.dao.RoleDao;
import com.livingwater.entities.BatchBottles;
import com.livingwater.entities.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
@Repository("batchBottlesDao")
@Transactional
public class BatchBottlesDaoImpl extends GenericDaoImpl<BatchBottles> implements BatchBottlesDao {

}
