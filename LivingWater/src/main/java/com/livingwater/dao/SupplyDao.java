package com.livingwater.dao;

import com.livingwater.entities.Supply;
import com.livingwater.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("supplyDao")
@Transactional
public interface SupplyDao extends GenericDao<Supply>{

}
