package com.livingwater.dao;

import com.livingwater.entities.Vehicle;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by John Leeroy Gadiane on 15/05/2017.
 */
@Repository("vehicleDao")
@Transactional
public interface VehicleDao extends GenericDao<Vehicle> {

    Vehicle getVehicle(int id);
    List<Vehicle> getAllVehicles();
}
