package com.ClientConnectivity.tradeSystem.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Order implements Serializable {
    @Id
    @Column(updatable = false, nullable = false)
    private final String Order_ID = UUID.randomUUID().toString(); //random UUID string
    private String productName; //product name
    private double price; //how much client is willing to buy or sell for
    private int quantity; // number of products to buy or sell
    private String side; // buy or sell order
    private final LocalDateTime timeCreated = LocalDateTime.now();

    public Order(String productName, double price, int quantity, String side) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.side = side;
    }

    public Order (){

    }

    public String getOrder_ID() {
        return Order_ID;
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

}
