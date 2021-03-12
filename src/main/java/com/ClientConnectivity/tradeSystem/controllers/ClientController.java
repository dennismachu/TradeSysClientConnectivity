package com.ClientConnectivity.tradeSystem.controllers;

import com.ClientConnectivity.tradeSystem.models.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

    @GetMapping("/client")
    public ResponseEntity<Client> getClient(){
        return new ResponseEntity<>(new Client("56","FASKDJ"), HttpStatus.OK);
    }


}
