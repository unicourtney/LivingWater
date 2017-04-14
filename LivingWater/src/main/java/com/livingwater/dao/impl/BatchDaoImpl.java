package com.livingwater.dao.impl;

import com.livingwater.dao.BatchDao;
import com.livingwater.dao.RoleDao;
import com.livingwater.entities.Batch;
import com.livingwater.entities.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
@Repository("batchDao")
@Transactional
public class BatchDaoImpl extends GenericDaoImpl<Batch> implements BatchDao {

}
