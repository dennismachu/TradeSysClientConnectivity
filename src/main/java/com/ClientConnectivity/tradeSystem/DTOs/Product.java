package com.ClientConnectivity.tradeSystem.DTOs;

import org.springframework.stereotype.Component;

@Component
public class Product {
    private String ticker;
    private double price; // current market price (last accepted market price)
                          // should interface with product pricing service
}
