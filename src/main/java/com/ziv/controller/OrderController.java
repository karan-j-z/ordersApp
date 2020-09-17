package com.ziv.controller;

import java.util.List;

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
