package com.ziv.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ziv.models.Order;
import com.ziv.models.Product;
import com.ziv.repositories.OrderRepository;
import com.ziv.repositories.ProductRepository;

import java.lang.reflect.Field;

@RestController
@RequestMapping("/api/orders/")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	ProductController productController;
	
	@GetMapping
	public List<Order> list()
	{
		return orderRepository.findAll();
	}
	
	@GetMapping
	@RequestMapping("{id}")
	public Order get(@PathVariable Integer id)
	{
		return orderRepository.getOne(id);
	}
	
	@GetMapping
	@RequestMapping("{id}/{dateFrom}+{dateTo}+")
	public List<Order> getOrdersByDate(@PathVariable Integer id, @PathVariable Date dateFrom, @PathVariable Date dateTo)
	{
		List<Order> orders = (List<Order>) orderRepository.findOrdersByCustomerBetweenDates(id, dateFrom, dateTo);
		
		return orders;
	}
	
	@GetMapping
	@RequestMapping("{id}/{dateFrom}+{dateTo}")
	public List<Integer> getOrderIdsByDate(@PathVariable Integer id, @PathVariable Date dateFrom, @PathVariable Date dateTo)
	{
		List<Integer> orderIds = orderRepository.findOrderIdsByCustomerBetweenDates(id, dateFrom, dateTo);
		
		return orderIds;
	}
	
	@GetMapping
	@RequestMapping("products/{dateFrom}+{dateTo}")
	public Map<Integer,Long> getProductsByDate(@PathVariable Date dateFrom, @PathVariable Date dateTo)
	{
		Map<Integer,Long> productsCount = new HashMap<>();
		
		List<Object[]> result = orderRepository.findOrdersByProductsBetweenDates(dateFrom, dateTo);
		for (Object[] obj: result) {
			Integer product_id = (Integer) obj[0];
			Long count = (Long) obj[1];
			productsCount.put(product_id, count);
		}
		return productsCount;
	}
	
	@PostMapping
	public  Order create(@RequestBody final Order order)
	{
		Integer quantity = order.getOrder_quantity();
		Integer product_id = order.getProduct_id();
		Product productToBeOrdered = productController.get(product_id);
		Integer newQuantity = productToBeOrdered.getProduct_quantity() - quantity;
		productToBeOrdered.setProduct_quantity(newQuantity);
		productController.update(product_id, productToBeOrdered);
		return orderRepository.saveAndFlush(order);
	}
	
	
	
	
	
	@RequestMapping(value="{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id)
	{
		orderRepository.deleteById(id);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public Order update(@PathVariable Integer id, @RequestBody Order order)
	{
		Order existingOrder = orderRepository.getOne(id);
		BeanUtils.copyProperties(order, existingOrder, "order_id");
		return orderRepository.saveAndFlush(existingOrder);
	}
	
}
