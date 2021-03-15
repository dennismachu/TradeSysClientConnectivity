package com.ClientConnectivity.tradeSystem.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class ProductOrder implements Serializable {
    @Id
    @Column(updatable = false, nullable = false)
    private final String orderID = UUID.randomUUID().toString(); //random UUID string
    private String productName; //product name
    private double productPrice; //how much client is willing to buy or sell for
    private int quantity; // number of products to buy or sell
    private String side; // buy or sell order
    private final LocalDateTime timeCreated = LocalDateTime.now();

    public ProductOrder(String productName, double price, int quantity, String side) {
        this.productName = productName;
        this.productPrice = price;
        this.quantity = quantity;
        this.side = side;
    }

    public ProductOrder(){

    }

    public String getOrderID() {
        return orderID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double price) {
        this.productPrice = price;
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
