package com.livingwater.dao.impl;

import com.livingwater.dao.RoleDao;
import com.livingwater.dao.TransactionBottlesDao;
import com.livingwater.entities.Role;
import com.livingwater.entities.TransactionBottles;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
@Repository("transactionBottlesDao")
@Transactional
public class TransactionBottlesDaoImpl extends GenericDaoImpl<TransactionBottles> implements TransactionBottlesDao {

    public List<TransactionBottles> getAllTransactionBottles() {
        Query query = getCurrentSession().createQuery("from TransactionBottles b ");
        return query.list();
    }

    public List<TransactionBottles> getAllBottlesWithATransactionIDLike(int transaction_id) {
        Query query = getCurrentSession().createQuery("from TransactionBottles b where transactionID = :transaction_id");
        query.setParameter("transaction_id", transaction_id);

        return query.list();
    }

    public List<TransactionBottles> getBottlesReturned(int id){
        Query query = getCurrentSession().createQuery("from TransactionBottles where transactionID = :id");
        query.setParameter("id", id);

        return query.list();
    }

    public List<TransactionBottles> getBottlesOnHand(int id){

        Query query = getCurrentSession().createQuery("from TransactionBottles where transactionID = :id");
        query.setParameter("id", id);


        return query.list();
    }


}
