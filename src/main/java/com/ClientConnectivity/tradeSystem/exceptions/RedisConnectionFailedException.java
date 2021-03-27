package com.ClientConnectivity.tradeSystem.exceptions;

public class RedisConnectionFailedException extends RuntimeException{
    public RedisConnectionFailedException(String message) {
        super(message);
    }
}
