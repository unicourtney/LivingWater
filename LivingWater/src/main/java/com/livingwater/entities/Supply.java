package com.livingwater.entities;

import javax.persistence.*;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */

@Entity
@Table(name = "supply")
public class Supply {

    @Id
    @Column(name = "supplyID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String supplyID;

    @Column(name = "name")
    private String name;

    @Column(name = "noOfItems")
    private Integer numberOfItems;

    public Supply() {
    }

    public Supply(String name, Integer numberOfItems) {

        this.name = name;
        this.numberOfItems = numberOfItems;
    }

    public String getSupplyID() {
        return supplyID;
    }

    public void setSupplyID(String supplyID) {
        this.supplyID = supplyID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
    }
}
