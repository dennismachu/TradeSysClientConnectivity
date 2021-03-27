package com.ClientConnectivity.tradeSystem.DAOs;


import com.ClientConnectivity.tradeSystem.DTOs.Client;
import com.ClientConnectivity.tradeSystem.DTOs.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PortfolioRepo extends JpaRepository<Portfolio,Long> {

    Optional<Portfolio> findPortfolioByID(Long ID);
}
