package com.ClientConnectivity.tradeSystem.DTOs;



import javax.persistence.*;


@Entity
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long ID;
    private String name;

}
