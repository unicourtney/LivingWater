package com.livingwater.dao;

import com.livingwater.entities.Bottle;
import com.livingwater.entities.Customer;
import com.livingwater.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("customerDao")
@Transactional
public interface CustomerDao extends GenericDao<Customer>{

    public List<Customer> getAllCustomer();

}
