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
    @OneToOne
    @JoinColumn(name = "transactionID")
    private Transaction transaction;

    @Id
    @OneToOne
    @JoinColumn(name = "bottleID")
    private Bottle bottle;

    public TransactionBottles() {
    }

    public TransactionBottles(Transaction transaction, Bottle bottle) {

        this.transaction = transaction;
        this.bottle = bottle;
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
}
