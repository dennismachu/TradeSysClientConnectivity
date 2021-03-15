package com.ClientConnectivity.tradeSystem.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long ID;


    private String name;
    //private double funds;
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



    @Override
    public String toString() {
        return "Client{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return name.equals(client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
