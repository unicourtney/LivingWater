package com.livingwater.dao;

import com.livingwater.entities.Dispenser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("dispenserDao")
@Transactional
public interface DispenserDao extends GenericDao<Dispenser>{

    public List<Dispenser> getAllDispenserFromCustomer(int id);

}
