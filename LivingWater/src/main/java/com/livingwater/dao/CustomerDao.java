package com.livingwater.dao;

import com.livingwater.entities.Customer;
import com.livingwater.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("customerDao")
@Transactional
public interface CustomerDao extends GenericDao<Customer>{

}
