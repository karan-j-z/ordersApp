package com.ziv.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ziv.models.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	
//	@Query("select s from Article s where s.author like ?1 and s.title = ?2")
//    List<Article> findByAuthorAndTitle(String author, String title);
	
//	@Query("SELECT order_id, product_id, customer_id, order_quantity,order_amount,order_date,delivery_date FROM orders WHERE customer_id = ?1 AND order_date BETWEEN ?2 AND ?3")
//	List<Order> findOrdersByCustomerBetweenDates(Integer customer_id, Date fromDate, Date toDate);

	@Query("SELECT order_id FROM orders WHERE customer_id = ?1 AND order_date BETWEEN ?2 AND ?3")
	List<Integer> findOrdersByCustomerBetweenDates(Integer customer_id, Date fromDate, Date toDate);


}
