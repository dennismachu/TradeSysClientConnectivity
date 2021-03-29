package com.ClientConnectivity.tradeSystem.DTOs;



import javax.persistence.*;
import java.util.List;


@Entity
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long ID;
    private String name;
    private Long client_id ;

    @ManyToMany(mappedBy = "portfolio_id",cascade = CascadeType.ALL)
    private List<Product> products;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
