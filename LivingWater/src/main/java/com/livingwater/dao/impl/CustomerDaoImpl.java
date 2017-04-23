package com.livingwater.dao.impl;

import com.livingwater.dao.CustomerDao;
import com.livingwater.dao.RoleDao;
import com.livingwater.entities.Customer;
import com.livingwater.entities.Role;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
@Repository("customerDao")
@Transactional
public class CustomerDaoImpl extends GenericDaoImpl<Customer> implements CustomerDao {

    public List<Customer> getAllCustomer() {
        Query query = getCurrentSession().createQuery("from Customer b");
        return query.list();
    }

    public Customer getCustomer(int id){
        Query query = getCurrentSession().createQuery("from Customer b where b.customerID = :id");
        query.setParameter("id",id);

        return (Customer)query.uniqueResult();
    }


}
