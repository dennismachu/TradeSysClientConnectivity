package com.ClientConnectivity.tradeSystem.services;

import com.ClientConnectivity.tradeSystem.Exceptions.ClientNotFoundException;
import com.ClientConnectivity.tradeSystem.models.Client;
import com.ClientConnectivity.tradeSystem.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientConnectivityService {
    private final ClientRepo clientRepo;

    @Autowired
    public ClientConnectivityService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public Client addClient (Client client){
        return clientRepo.save(client);
    }

    public List<Client> getAllClients (){
        return clientRepo.findAll();
    }

    public Client findClientById(Long ID){
        return clientRepo.findById(ID)
                .orElseThrow(() -> new ClientNotFoundException("Client with ID: "+ ID +" was not found "));
    }

}
