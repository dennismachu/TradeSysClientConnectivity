package com.ClientConnectivity.tradeSystem.utils;

import com.ClientConnectivity.tradeSystem.DTOs.Product;
import com.ClientConnectivity.tradeSystem.DTOs.ProductOrder;
import com.ClientConnectivity.tradeSystem.services.ClientConnectivityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

@Service
public class ClientConnSub extends JedisPubSub {

    @Autowired
    ClientConnectivityService ccs;

    @Override
    public void onMessage(String channel, String message) {
        System.out.println("This is the order Id: "+ message);

        ObjectMapper objectMapper = new ObjectMapper();
        ProductOrder storedOrder = null;

        try {
            storedOrder = objectMapper.readValue(message,ProductOrder.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(storedOrder.toString());

        ccs.addOrder(storedOrder);

    }


}
