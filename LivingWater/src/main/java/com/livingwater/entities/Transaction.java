package com.livingwater.entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @Column(name = "transactionID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String transactionID;

    @ManyToOne
    @JoinColumn(name = "customerID")
    private Customer customer;

    @Column(name = "numberOfBottles")
    private Integer numberOfBottles;

    @Column(name = "totalCost")
    private Double totalCost;

    @Column(name = "dateOfDelivery")
    private Date dateOfDelivery;

    public Transaction(Customer customer, Integer numberOfBottles, Double totalCost, Date dateOfDelivery) {
        this.customer = customer;
        this.numberOfBottles = numberOfBottles;
        this.totalCost = totalCost;
        this.dateOfDelivery = dateOfDelivery;
    }

    public Transaction() {
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getNumberOfBottles() {
        return numberOfBottles;
    }

    public void setNumberOfBottles(Integer numberOfBottles) {
        this.numberOfBottles = numberOfBottles;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Date getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(Date dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }
}
