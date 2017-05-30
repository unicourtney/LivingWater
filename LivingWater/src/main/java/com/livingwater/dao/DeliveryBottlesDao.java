package com.livingwater.dao;

import com.livingwater.entities.Bottle;
import com.livingwater.entities.Delivery;
import com.livingwater.entities.DeliveryBottles;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by John Leeroy Gadiane on 23/05/2017.
 */
@Repository("deliveryBottlesDao")
@Transactional
public interface DeliveryBottlesDao extends GenericDao<DeliveryBottles>{

    boolean isBottlesInDB(Delivery delivery, Bottle bottle);

    List<DeliveryBottles> getAll(Delivery delivery);

}
