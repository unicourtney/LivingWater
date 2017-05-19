package com.livingwater.entities;

/**
 * Created by CourtneyLove on 5/17/2017.
 */
public class CustomerBottles
{

    private String bottlesOnHand, bottlesReturned;

    public CustomerBottles() {
    }

    public CustomerBottles(String bottlesOnHand, String bottlesReturned) {
        this.bottlesOnHand = bottlesOnHand;
        this.bottlesReturned = bottlesReturned;
    }

    public String getBottlesOnHand() {
        return bottlesOnHand;
    }

    public void setBottlesOnHand(String bottlesOnHand) {
        this.bottlesOnHand = bottlesOnHand;
    }

    public String getBottlesReturned() {
        return bottlesReturned;
    }

    public void setBottlesReturned(String bottlesReturned) {
        this.bottlesReturned = bottlesReturned;
    }
}
