package com.ClientConnectivity.tradeSystem.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String ticker;
    private double lastTradedPrice; // current market price (last accepted market price)
                                    // should interface with product pricing service


    public Product(String ticker, double lastTradedPrice) {
        this.ticker = ticker;
        this.lastTradedPrice = lastTradedPrice;
    }

    public Product(){

    }

    public Long getId() {
        return id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public double getLastTradedPrice() {
        return lastTradedPrice;
    }

    public void setLastTradedPrice(double lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
    }


}
