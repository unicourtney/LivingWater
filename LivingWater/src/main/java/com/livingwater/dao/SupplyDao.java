package com.livingwater.dao;

import com.livingwater.entities.Supply;
import com.livingwater.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("supplyDao")
@Transactional
public interface SupplyDao extends GenericDao<Supply>{

    public List<Supply> getAllSupply();
}
