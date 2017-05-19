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

    public List<Transaction> getCustomerTransaction(int id) {

        Query query = getCurrentSession().createQuery("from Transaction where customerID = :id");
        query.setParameter("id", id);


        return query.list();
    }

    public Transaction getBottlesOnHand(int id) {

        Query query = getCurrentSession().createQuery("from Transaction where customerID = :id order by dateOfDelivery ASC ");
        query.setParameter("id", id);
        List<Transaction> transactionList = query.list();
        Transaction transaction;
        if (transactionList.size() > 1) {
            query.setFirstResult(0);
            query.setMaxResults(1);
            transaction = (Transaction) query.uniqueResult();
            System.out.println("SIZE ---- " + transactionList.size());
        } else {
            System.out.println("SIZE ---- " + transactionList.size());
            transaction = (Transaction) query.uniqueResult();
        }


        return transaction;
    }

    public Transaction getBottlesReturned(int id) {

        Query query = getCurrentSession().createQuery("from Transaction where customerID = :id order by dateOfDelivery ASC");
        query.setParameter("id", id);
        List<Transaction> transactionList = query.list();
        Transaction transaction = null;
        if(transactionList.size()!=1) {
           transaction = new Transaction();
            int row = transactionList.size() - 1;
            transaction.setTransactionID(transactionList.get(row).getTransactionID());
        }

        return transaction;
    }

}
