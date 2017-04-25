package com.livingwater.dao;

import com.livingwater.entities.BatchBottles;
import com.livingwater.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("batchBottlesDao")
@Transactional
public interface BatchBottlesDao extends GenericDao<BatchBottles>{

    public boolean isBatchBottlesInDB(int batchID, String bottleID);

    public BatchBottles getLastRecord();

    List<BatchBottles> getAllBottles(int batchID);

}
