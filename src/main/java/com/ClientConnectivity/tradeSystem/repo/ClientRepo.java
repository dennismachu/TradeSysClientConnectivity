package com.ClientConnectivity.tradeSystem.repo;

import com.ClientConnectivity.tradeSystem.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client,Long> {

}
