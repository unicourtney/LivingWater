package com.livingwater.dao;

import com.livingwater.entities.TransactionBottles;
import com.livingwater.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("transactionBottlesDao")
@Transactional
public interface TransactionBottlesDao extends GenericDao<TransactionBottles>{

    public List<TransactionBottles> getAllTransactionBottles();

    public List<TransactionBottles> getAllBottlesWithATransactionIDLike(int transaction_id);

    public List<TransactionBottles> getBottlesReturned(int id);

    public List<TransactionBottles> getBottlesOnHand(int id);

}
