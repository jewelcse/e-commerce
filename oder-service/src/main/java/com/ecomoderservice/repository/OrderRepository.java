package com.ecomoderservice.repository;

import com.ecomoderservice.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;


@Repository
public interface OrderRepository extends MongoRepository<Order,String> {
     ArrayList<Order> findByCustomer_CustomerId(Long id);

}
