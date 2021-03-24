package com.ClientConnectivity.tradeSystem.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
public class ProductOrder implements Serializable {

    @Id
    @Column(updatable = false, nullable = false)
    private final String id = UUID.randomUUID().toString(); //random UUID string;

    private String productName; //product name

    private Long clientId;

    private double funds;

    private int quantityOwned;

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

    public Long getClientId() {
        return clientId;
    }

    public double getFunds() {
        return funds;
    }

    public int getQuantityOwned() {
        return quantityOwned;
    }

    public void setQuantityOwned(int quantityOwned) {
        this.quantityOwned = quantityOwned;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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
