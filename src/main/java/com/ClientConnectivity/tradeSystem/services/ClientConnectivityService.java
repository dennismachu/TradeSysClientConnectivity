package com.ClientConnectivity.tradeSystem.services;

import com.ClientConnectivity.tradeSystem.models.Client;
import com.ClientConnectivity.tradeSystem.exceptions.ClientNotFoundException;
import com.ClientConnectivity.tradeSystem.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientConnectivityService{

   @Autowired
   private ClientRepo clientRepo;

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



}
