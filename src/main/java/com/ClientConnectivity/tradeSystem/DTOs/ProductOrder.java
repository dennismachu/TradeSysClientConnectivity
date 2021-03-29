package com.ClientConnectivity.tradeSystem.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long ID;

    private String orderId;
    private String productName; //product name
    private double price; //how much client is willing to buy or sell for
    private int quantity; // number of products to buy or sell
    private String side; // buy or sell order
    @CreationTimestamp
    private java.sql.Time timeCreated;

    private Long client_id ;
    private Long portfolio_id;

    public ProductOrder() {

    }

    public ProductOrder(String orderId, String productName, int quantity, double price, String side) {
        this.orderId = orderId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.side = side;
    }

    public String getProductName() {
        return productName;
    }


    public String getOrderId() {
        return orderId;
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

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public Long getPortfolio_id() {
        return portfolio_id;
    }

    public void setPortfolio_id(Long portfolio_id) {
        this.portfolio_id = portfolio_id;
    }

    @Override
    public String toString() {
        return "ProductOrder{" +
                "ID=" + ID +
                ", orderId='" + orderId + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", side='" + side + '\'' +
                ", timeCreated=" + timeCreated +
                ", client_id=" + client_id +
                ", portfolio_id=" + portfolio_id +
                '}';
    }
}
