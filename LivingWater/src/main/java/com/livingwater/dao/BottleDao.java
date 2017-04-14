package com.livingwater.dao;

import com.livingwater.entities.Bottle;
import com.livingwater.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("bottleDao")
@Transactional
public interface BottleDao extends GenericDao<Bottle>{

}
