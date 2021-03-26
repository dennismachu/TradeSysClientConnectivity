package com.ClientConnectivity.tradeSystem.DTOs;


import javax.persistence.*;
import java.io.Serializable;



@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long ID;


    private String name;
    private double funds;
   // private List<Portfolio> portfolios;

    public Client(){
    }

    public Client( String name) {
        this.name = name;
    }

    public Long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }


}
