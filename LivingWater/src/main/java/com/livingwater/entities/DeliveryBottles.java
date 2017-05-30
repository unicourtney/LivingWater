package com.livingwater.entities;

import javax.persistence.*;

/**
 * Created by John Leeroy Gadiane on 23/05/2017.
 */

@Entity
@Table(name="deliveryBottles")
public class DeliveryBottles {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    @ManyToOne
    @JoinColumn(name = "deliveryID")
    public Delivery delivery;

    @ManyToOne
    @JoinColumn(name = "bottleID")
    public Bottle bottle;

    public DeliveryBottles(Delivery delivery, Bottle bottle) {
        this.delivery = delivery;
        this.bottle = bottle;
    }

    public DeliveryBottles() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Bottle getBottle() {
        return bottle;
    }

    public void setBottle(Bottle bottle) {
        this.bottle = bottle;
    }
}
