package com.ClientConnectivity.tradeSystem.services;

import com.ClientConnectivity.tradeSystem.DAOs.OrderRepo;
import com.ClientConnectivity.tradeSystem.DTOs.Client;
import com.ClientConnectivity.tradeSystem.DTOs.ProductOrder;
import com.ClientConnectivity.tradeSystem.exceptions.ClientNotFoundException;
import com.ClientConnectivity.tradeSystem.DAOs.ClientRepo;
import com.ClientConnectivity.tradeSystem.exceptions.RedisConnectionFailedException;
import com.ClientConnectivity.tradeSystem.utils.ClientConnRedisClient;
import com.ClientConnectivity.tradeSystem.utils.ClientConnSub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service
public class ClientConnectivityService{

    @Autowired
    private ClientConnSub clientConnSub;

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private OrderRepo orderRepo;

    public Client addClient (Client client){
        return this.clientRepo.save(client);
    }

    public List<Client> getAllClients (){
        return this.clientRepo.findAll();
    }

    public Client findClientByID(Long ID){
        return this.clientRepo.findClientByID(ID)
                .orElseThrow(() -> new ClientNotFoundException("Client with ID: "+ ID +" was not found "));
    }

    public void deleteClientByID(Long ID){
        this.clientRepo.deleteById(ID);
    }

    public void addOrder (ProductOrder order){
        System.out.println("Saved: " + this.orderRepo.save(order));
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run(){
        //have redisClient connect pub sub(subscriber) and channel
        Jedis redisSubscriber;
        try {
            //connect to redis server and send order data
            redisSubscriber = ClientConnRedisClient.connect();
        }catch (RedisConnectionFailedException rcx){
            throw new RedisConnectionFailedException("Trade engine Subscriber connection to redis server failed.");
        }

        redisSubscriber.subscribe(clientConnSub,"saveOrder");
    }


}
