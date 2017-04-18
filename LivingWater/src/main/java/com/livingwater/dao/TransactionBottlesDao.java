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

}
