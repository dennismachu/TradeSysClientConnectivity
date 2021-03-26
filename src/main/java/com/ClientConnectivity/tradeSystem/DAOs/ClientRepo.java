package com.ClientConnectivity.tradeSystem.DAOs;

import com.ClientConnectivity.tradeSystem.DTOs.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<Client,Long> {

    Optional<Client> findClientByID(Long ID);


}
