package com.ClientConnectivity.tradeSystem.controllers;

import com.ClientConnectivity.tradeSystem.models.Client;
import com.ClientConnectivity.tradeSystem.models.ProductOrder;
import com.ClientConnectivity.tradeSystem.services.ClientConnectivityService;
import com.ClientConnectivity.tradeSystem.services.OrderValidationClient;
import com.example.consumingwebservice.wsdl.PostOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/client")
public class ClientController {

    @Autowired
    OrderValidationClient orderValidationClient;

    private final ClientConnectivityService ccs;

    public ClientController(ClientConnectivityService ccs) {
        this.ccs = ccs;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Client>> getClients(){
      return new ResponseEntity<>(this.ccs.getAllClients(),HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> addClient ( @RequestBody Client client){

        Client savedClient = this.ccs.addClient(client);

       if (savedClient.equals(client)){
           return new ResponseEntity<>("Saved", HttpStatus.CREATED);
       }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong while saving.");
    }

    @DeleteMapping(value = "/delete/{id}")
    public  ResponseEntity<?> deleteClient (@PathVariable("id") Long id){
        this.ccs.deleteClientByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findClientByID (@PathVariable("id") Long id){
        return new ResponseEntity<>(this.ccs.findClientByID(id),HttpStatus.OK);
    }

    @PostMapping(value = "/validate")
    public ResponseEntity<PostOrderResponse> validateOrder (@RequestBody ProductOrder productOrder){

        PostOrderResponse newResponse = orderValidationClient.validateOrder(productOrder);
        return new ResponseEntity<>(newResponse,HttpStatus.OK);

    }

}
