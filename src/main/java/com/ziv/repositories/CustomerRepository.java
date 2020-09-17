package com.ziv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ziv.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
