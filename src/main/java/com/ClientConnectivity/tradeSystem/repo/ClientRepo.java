package com.ClientConnectivity.tradeSystem.repo;

import com.ClientConnectivity.tradeSystem.models.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<Client,Long> {

    Optional<Client> findClientByID(Long ID);


}
