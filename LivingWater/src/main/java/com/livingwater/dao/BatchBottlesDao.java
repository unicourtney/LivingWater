package com.livingwater.dao;

import com.livingwater.entities.BatchBottles;
import com.livingwater.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("batchBottlesDao")
@Transactional
public interface BatchBottlesDao extends GenericDao<BatchBottles>{

    public boolean isBatchBottlesInDB(int batchID, int bottleID);

}
