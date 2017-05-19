package com.livingwater.dao.impl;

import com.livingwater.dao.GenericDao;
import com.livingwater.dao.VehicleDao;
import com.livingwater.entities.Vehicle;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by John Leeroy Gadiane on 15/05/2017.
 */
@Repository("vehicleDao")
@Transactional
public class VehicleDaoImpl extends GenericDaoImpl<Vehicle> implements VehicleDao{
    public Vehicle getVehicle(int id) {
        Query query = getCurrentSession().createQuery("from Vehicle where plateNumber = :id");
        query.setParameter("id",id);
        return (Vehicle) query.uniqueResult();
    }

    public List<Vehicle> getAllVehicles(){
        Query query = getCurrentSession().createQuery("from Vehicle");
        return query.list();

    }

}
