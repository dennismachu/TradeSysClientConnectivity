package com.ClientConnectivity.tradeSystem.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;


public class ProductOrder implements Serializable {

    private final String id = UUID.randomUUID().toString(); //random UUID string;
    private String productName; //product name
    private double price; //how much client is willing to buy or sell for
    private int quantity; // number of products to buy or sell
    private String side; // buy or sell order
    private final LocalDateTime timeCreated = LocalDateTime.now();

    public String getID() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }
}
