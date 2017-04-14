package com.livingwater.dao;

import com.livingwater.entities.Transaction;
import com.livingwater.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("transactionDao")
@Transactional
public interface TransactionDao extends GenericDao<Transaction>{

}
