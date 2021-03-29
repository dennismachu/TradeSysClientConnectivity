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

    public Client(String username, double funds, String password) {
        this.username = username;
        this.funds = funds;
        this.password = password;
    }

    public Client(){
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Long getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }


}
