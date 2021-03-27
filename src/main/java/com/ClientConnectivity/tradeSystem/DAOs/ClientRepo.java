package com.ClientConnectivity.tradeSystem.DAOs;

import com.ClientConnectivity.tradeSystem.DTOs.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<Client,Long> {

    Optional<Client> findClientByID(Long ID);

//   @Query("select * from client c where c.username= :username and c.password = :password")
//   Optional<Client> authenticate(@Param("username") String username, @Param("password") String password);


}
