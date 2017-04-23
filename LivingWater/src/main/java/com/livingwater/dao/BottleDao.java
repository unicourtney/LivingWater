package com.livingwater.dao;

import com.livingwater.entities.Bottle;
import com.livingwater.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("bottleDao")
@Transactional
public interface BottleDao extends GenericDao<Bottle>{

/*    public List<Bottle> getAllBottle();

    public Bottle getABottle(int id);*/


}
