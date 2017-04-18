package com.livingwater.dao.impl;

import com.livingwater.dao.BatchBottlesDao;
import com.livingwater.dao.RoleDao;
import com.livingwater.entities.BatchBottles;
import com.livingwater.entities.Role;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
@Repository("batchBottlesDao")
@Transactional
public class BatchBottlesDaoImpl extends GenericDaoImpl<BatchBottles> implements BatchBottlesDao {

    public boolean isBatchBottlesInDB(int batchID, int bottleID) {
        Query query = getCurrentSession().createQuery("from BatchBottles b where b.batchID = :batchID and b.bottleID = :bottleID");
        query.setParameter("batchID",batchID);
        query.setParameter("bottleID",bottleID);

        if(query.uniqueResult() != null){
            return true;
        }
        return false;
    }
}
