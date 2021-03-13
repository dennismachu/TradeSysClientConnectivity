package com.ClientConnectivity.tradeSystem.models;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Portfolio {
    private String name;
    private List<Stock> stocks;
}
