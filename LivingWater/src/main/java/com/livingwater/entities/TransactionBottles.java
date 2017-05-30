package com.livingwater.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
@Entity
@Table(name = "transactionBottles")
public class TransactionBottles implements Serializable{
    @Id
//    @OneToOne
    @ManyToOne
    @JoinColumn(name = "transactionID")
    private Transaction transaction;

    @Id
    @OneToOne
    @JoinColumn(name = "bottleID")
    private Bottle bottle;

    @Column(name = "status")
    private String status;

    public TransactionBottles() {
    }

    public TransactionBottles(Transaction transaction, Bottle bottle, String status) {

        this.transaction = transaction;
        this.bottle = bottle;
        this.status = status;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Bottle getBottle() {
        return bottle;
    }

    public void setBottle(Bottle bottle) {
        this.bottle = bottle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

