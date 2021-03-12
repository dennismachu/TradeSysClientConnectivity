package com.ClientConnectivity.tradeSystem.models;

import java.io.Serializable;


public class Client implements Serializable {
    private String ID;
    private String name;
   // private List<Portfolio> portfolios;


    public Client(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
