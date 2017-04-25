package com.livingwater.dao;

import com.livingwater.entities.Batch;
import com.livingwater.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("batchDao")
@Transactional
public interface BatchDao extends GenericDao<Batch>{

    public List<Batch> getAllBatch();

    public Batch getBatch(int id);

}
