package com.livingwater.dao;

import com.livingwater.entities.Dispenser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("dispenserDao")
@Transactional
public interface DispenserDao extends GenericDao<Dispenser>{

}
