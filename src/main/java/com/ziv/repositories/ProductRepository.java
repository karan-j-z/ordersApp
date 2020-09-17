package com.ziv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ziv.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
