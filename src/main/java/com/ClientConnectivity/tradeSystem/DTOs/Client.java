package com.ClientConnectivity.tradeSystem.DTOs;


import javax.persistence.*;
import java.io.Serializable;



@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long ID;
    private String username;
    private double funds;
    private String password;

    public Client(String name, double funds, String password) {
        this.username = name;
        this.password = password;
        this.funds = funds;

    }

    public Client(){
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Client(String name) {
        this.username = name;
    }

    public Long getID() {
        return ID;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }


}
