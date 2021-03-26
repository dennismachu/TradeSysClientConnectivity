package com.ClientConnectivity.tradeSystem.DAOs;

import com.ClientConnectivity.tradeSystem.DTOs.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<ProductOrder,String> {


}
