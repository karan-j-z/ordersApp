package com.ziv.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ziv.models.Product;
import com.ziv.repositories.ProductRepository;

@RestController
@RequestMapping("/api/products/")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public List<Product> list()
	{
		return productRepository.findAll();
	}
	
	@GetMapping
	@RequestMapping("{id}")
	public Product get(@PathVariable Integer id)
	{
		return productRepository.getOne(id);
	}
	
	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
	public Product create(@RequestBody final Product product)
	{
		return productRepository.saveAndFlush(product);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id)
	{
//		Also need to check for child records before deleting
		productRepository.deleteById(id);
	}
	
	@RequestMapping(value="{id}",method = RequestMethod.PUT)
	public Product update(@PathVariable Integer id, @RequestBody Product product)
	{
		//since it is PUT, all attributes are to be passed in. PATCH would need only those to be updated
		//TODO: add validation that all fields are passed in, else return 400
		Product existingProduct = productRepository.getOne(id);
		BeanUtils.copyProperties(product, existingProduct,"product_id");
		return productRepository.saveAndFlush(existingProduct);
	}
	
}
