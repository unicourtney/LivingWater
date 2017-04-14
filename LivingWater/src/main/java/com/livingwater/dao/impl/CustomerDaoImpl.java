package com.livingwater.dao.impl;

import com.livingwater.dao.CustomerDao;
import com.livingwater.dao.RoleDao;
import com.livingwater.entities.Customer;
import com.livingwater.entities.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
@Repository("customerDao")
@Transactional
public class CustomerDaoImpl extends GenericDaoImpl<Customer> implements CustomerDao {

}
