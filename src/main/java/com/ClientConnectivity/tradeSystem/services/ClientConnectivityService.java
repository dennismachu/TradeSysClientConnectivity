package com.ClientConnectivity.tradeSystem.services;

import com.ClientConnectivity.tradeSystem.DAOs.OrderRepo;
import com.ClientConnectivity.tradeSystem.DAOs.PortfolioRepo;
import com.ClientConnectivity.tradeSystem.DAOs.ProductRepo;
import com.ClientConnectivity.tradeSystem.DTOs.Client;
import com.ClientConnectivity.tradeSystem.DTOs.Portfolio;
import com.ClientConnectivity.tradeSystem.DTOs.Product;
import com.ClientConnectivity.tradeSystem.DTOs.ProductOrder;
import com.ClientConnectivity.tradeSystem.exceptions.*;
import com.ClientConnectivity.tradeSystem.DAOs.ClientRepo;
import com.ClientConnectivity.tradeSystem.utils.ClientConnRedisClient;
import com.ClientConnectivity.tradeSystem.utils.ClientConnSub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.Optional;

@Service
public class ClientConnectivityService{

    @Autowired
    private ClientConnSub clientConnSub;

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private PortfolioRepo portfolioRepo;

    @Autowired
    private ProductRepo productRepo;

//    public boolean authenticate (String username, String password){
//        boolean result = false;
//         Client client = this.clientRepo.authenticate(username,password).
//                 orElseThrow(()->new UserNotFoundException("User not found"));
//
//         if (client.getName().equals(username) && client.getPassword().equals(password)){
//             result = true;
//         }
//
//         return result;
//    }

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

    public ProductOrder addOrder (ProductOrder order){
        return this.orderRepo.save(order);
    }

    public void deleteOrderByID(Long ID){
        this.orderRepo.deleteById(ID);
    }

    public ProductOrder findOrderByID(Long ID){
        return this.orderRepo.findProductOrderByID(ID)
                .orElseThrow(()-> new OrderNotFoundException("Order with ID: "+ ID +" was not found"));
    }

    public List<ProductOrder> getAllOrders (){
        return this.orderRepo.findAll();
    }

    public Portfolio addPortfolio (Portfolio portfolio){
        return this.portfolioRepo.save(portfolio) ;
    }

    public Portfolio findPortfolioByID(Long ID){
        return this.portfolioRepo.findPortfolioByID(ID)
                .orElseThrow(()-> new PortfolioNotFoundException("Portfolio with ID: "+ID + " was not found."));
    }

    public List<Portfolio> getAllPortfolios (){
        return this.portfolioRepo.findAll();
    }

    public void deletePortfolioByID(Long ID){
        this.portfolioRepo.deleteById(ID);
    }

    public Product addProduct (Product product){
        return this.productRepo.save(product);
    }

    public void deleteProductByID(Long ID){
        this.productRepo.deleteById(ID);
    }

    public Product findProductByID(Long ID){
        return this.productRepo.findProductByID(ID)
                .orElseThrow(()-> new ProductNotFoundException("Product with ID: "+ ID +" was not found"));
    }

    public List<Product> getAllProducts (){
        return this.productRepo.findAll();
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
