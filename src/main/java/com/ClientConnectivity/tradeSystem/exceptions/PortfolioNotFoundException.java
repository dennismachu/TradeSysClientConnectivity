package com.ClientConnectivity.tradeSystem.exceptions;

public class PortfolioNotFoundException extends RuntimeException{
    public PortfolioNotFoundException(String message) {
        super(message);
    }
}
