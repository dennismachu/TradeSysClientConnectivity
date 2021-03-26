package com.ClientConnectivity.tradeSystem.DTOs;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Portfolio {
    private String name;
    private List<Product> products;
}
