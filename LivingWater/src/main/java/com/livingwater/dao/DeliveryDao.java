package com.livingwater.dao;

import com.livingwater.entities.Delivery;
import com.livingwater.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("deliveryDao")
@Transactional
public interface DeliveryDao extends GenericDao<Delivery>{

    public List<Delivery> getAllDelivery();

    public Delivery getADelivery(int id);

}
