package com.ClientConnectivity.tradeSystem.controllers;

import com.ClientConnectivity.tradeSystem.DTOs.Client;
import com.ClientConnectivity.tradeSystem.DTOs.Portfolio;
import com.ClientConnectivity.tradeSystem.DTOs.Product;
import com.ClientConnectivity.tradeSystem.services.ClientConnectivityService;
import com.ClientConnectivity.tradeSystem.utils.OrderValidationClient;
import com.example.consumingwebservice.wsdl.PostOrderResponse;
import com.example.consumingwebservice.wsdl.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    OrderValidationClient orderValidationClient;

    private final ClientConnectivityService ccs;

    public ClientController(ClientConnectivityService ccs) {
        this.ccs = ccs;
    }

    @GetMapping(path = "client/all")
    public ResponseEntity<List<Client>> getClients(){
      return new ResponseEntity<>(this.ccs.getAllClients(),HttpStatus.OK);
    }

    @PostMapping(value = "client/add")
    public ResponseEntity<String> addClient ( @RequestBody Client client){

        Client savedClient = this.ccs.addClient(client);

       if (savedClient.equals(client)){
           return new ResponseEntity<>("Saved", HttpStatus.CREATED);
       }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong while saving.");
    }

    @DeleteMapping(value = "client/delete/{id}")
    public  ResponseEntity<?> deleteClient (@PathVariable("id") Long id){
        this.ccs.deleteClientByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("client/{id}")
    public ResponseEntity<Client> findClientByID (@PathVariable("id") Long id){
        return new ResponseEntity<>(this.ccs.findClientByID(id),HttpStatus.OK);
    }

    @PostMapping(value = "client/makeorder")
    public ResponseEntity<PostOrderResponse> makeOrder (@RequestBody ProductOrder productOrder){

        //Client client = ccs.findClientByID();

           productOrder.setFunds(100000);
           productOrder.setQuantityOwned(5000);


        PostOrderResponse newResponse = orderValidationClient.validateOrder(productOrder);
        return new ResponseEntity<>(newResponse,HttpStatus.OK);

    }

    @GetMapping(path = "order/all")
    public ResponseEntity<List<com.ClientConnectivity.tradeSystem.DTOs.ProductOrder>> getOrders(){
        return new ResponseEntity<>(this.ccs.getAllOrders(),HttpStatus.OK);
    }

    @PostMapping(value = "order/add")
    public ResponseEntity<String> addOrder ( @RequestBody com.ClientConnectivity.tradeSystem.DTOs.ProductOrder order){

        com.ClientConnectivity.tradeSystem.DTOs.ProductOrder savedOrder = this.ccs.addOrder(order);

        if (savedOrder.equals(order)){
            return new ResponseEntity<>("Saved", HttpStatus.CREATED);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong while saving.");
    }

    @DeleteMapping(value = "order/delete/{id}")
    public  ResponseEntity<?> deleteOrder (@PathVariable("id") Long id){
        this.ccs.deleteOrderByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("order/{id}")
    public ResponseEntity<com.ClientConnectivity.tradeSystem.DTOs.ProductOrder> findOrderByID (@PathVariable("id") Long id){
        return new ResponseEntity<>(this.ccs.findOrderByID(id),HttpStatus.OK);
    }

    @GetMapping(path = "portfolio/all")
    public ResponseEntity<List<Portfolio>> getPortfolios(){
        return new ResponseEntity<>(this.ccs.getAllPortfolios(),HttpStatus.OK);
    }

    @PostMapping(value = "portfolio/add")
    public ResponseEntity<String> addPortfolio ( @RequestBody Portfolio portfolio){

        Portfolio savedPortfolio = this.ccs.addPortfolio(portfolio);

        if (savedPortfolio.equals(portfolio)){
            return new ResponseEntity<>("Saved", HttpStatus.CREATED);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong while saving.");
    }

    @DeleteMapping(value = "portfolio/delete/{id}")
    public  ResponseEntity<?> deletePortfolio (@PathVariable("id") Long id){
        this.ccs.deletePortfolioByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("portfolio/{id}")
    public ResponseEntity<Portfolio> findPortfolioByID (@PathVariable("id") Long id){
        return new ResponseEntity<>(this.ccs.findPortfolioByID(id),HttpStatus.OK);
    }


    @GetMapping(path = "product/all")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(this.ccs.getAllProducts(),HttpStatus.OK);
    }

    @PostMapping(value = "product/add")
    public ResponseEntity<String> addProduct ( @RequestBody Product product){

        Product savedProduct = this.ccs.addProduct(product);

        if (savedProduct.equals(product)){
            return new ResponseEntity<>("Saved", HttpStatus.CREATED);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong while saving.");
    }

    @DeleteMapping(value = "product/delete/{id}")
    public  ResponseEntity<?> deleteProduct (@PathVariable("id") Long id){
        this.ccs.deleteProductByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("product/{id}")
    public ResponseEntity<Product> findProductByID (@PathVariable("id") Long id){
        return new ResponseEntity<>(this.ccs.findProductByID(id),HttpStatus.OK);
    }
}
