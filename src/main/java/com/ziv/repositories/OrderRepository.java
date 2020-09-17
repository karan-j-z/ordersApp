package com.ziv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ziv.models.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
