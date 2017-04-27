package com.livingwater.dao.impl;

import com.livingwater.dao.RoleDao;
import com.livingwater.dao.TransactionDao;
import com.livingwater.entities.Role;
import com.livingwater.entities.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
@Repository("transactionDao")
@Transactional
public class TransactionDaoImpl extends GenericDaoImpl<Transaction> implements TransactionDao {

    public List<Transaction> getAllTransaction() {
        Query query = getCurrentSession().createQuery("from Transaction b");
        return query.list();
    }

    public Transaction getLastRecord() {

        Query query = getCurrentSession().createQuery("from Transaction b order by b.transactionID DESC");
        query.setMaxResults(1);
        Transaction transaction = (Transaction) query.uniqueResult();

        return transaction;
    }

    public Transaction getTransaction(int id) {

        Query query = getCurrentSession().createQuery("from Transaction b where b.transactionID = :id");
        query.setParameter("id", id);
        Transaction transaction = (Transaction) query.uniqueResult();

        return transaction;
    }

}
