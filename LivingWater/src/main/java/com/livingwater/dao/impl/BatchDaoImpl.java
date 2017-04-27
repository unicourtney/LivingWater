package com.livingwater.dao.impl;

import com.livingwater.dao.BatchDao;
import com.livingwater.dao.RoleDao;
import com.livingwater.entities.Batch;
import com.livingwater.entities.Role;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
@Repository("batchDao")
@Transactional
public class BatchDaoImpl extends GenericDaoImpl<Batch> implements BatchDao {

    public List<Batch> getAllBatch() {
        Query query = getCurrentSession().createQuery("from Batch b");

        return query.list();
    }

    public Batch getBatch(int id) {
        Query query = getCurrentSession().createQuery("from Batch b where b.batchID = :id");
        query.setParameter("id", id);

        return (Batch) query.uniqueResult();
    }

    public Batch getABatch(int batchID) {
        Query query = getCurrentSession().createQuery("from Batch where batchID = :id");
        query.setParameter("id", batchID);
        return (Batch) query.uniqueResult();
    }

}
