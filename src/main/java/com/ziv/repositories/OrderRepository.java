package com.ziv.repositories;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ziv.models.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	
//	@Query("select s from Article s where s.author like ?1 and s.title = ?2")
//    List<Article> findByAuthorAndTitle(String author, String title);
	
//	@Query(value = "SELECT order_id, product_id, customer_id, order_quantity,order_amount,order_date,delivery_date FROM orders WHERE customer_id = ?1 AND order_date BETWEEN ?2 AND ?3", nativeQuery = true)
	@Query(value = "SELECT * FROM orders WHERE customer_id = ?1 AND order_date BETWEEN ?2 AND ?3", nativeQuery = true)
	List<Order> findOrdersByCustomerBetweenDates(Integer customer_id, Date fromDate, Date toDate);

	@Query("SELECT order_id FROM orders WHERE customer_id = ?1 AND order_date BETWEEN ?2 AND ?3")
	List<Integer> findOrderIdsByCustomerBetweenDates(Integer customer_id, Date fromDate, Date toDate);
	
	@Query("SELECT product_id, COUNT(product_id) FROM orders WHERE (order_date BETWEEN ?1 AND ?2) GROUP BY product_id")
	List<Object[]> findOrdersByProductsBetweenDates(Date fromDate, Date toDate);


}
