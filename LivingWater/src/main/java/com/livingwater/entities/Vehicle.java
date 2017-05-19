package com.livingwater.entities;

import javax.persistence.*;

/**
 * Created by John Leeroy Gadiane on 15/05/2017.
 */
@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @Column(name = "plateNumber")
    private Integer plateNumber;

    @Column(name = "model")
    private String model;

    @Column(name = "brand")
    private String brand;

    public Vehicle() {
    }

    public Integer getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(Integer plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
