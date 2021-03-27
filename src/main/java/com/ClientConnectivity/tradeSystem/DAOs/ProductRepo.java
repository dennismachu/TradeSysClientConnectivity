package com.ClientConnectivity.tradeSystem.DAOs;

import com.ClientConnectivity.tradeSystem.DTOs.Client;
import com.ClientConnectivity.tradeSystem.DTOs.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    Optional<Product> findProductByID(Long ID);
}
