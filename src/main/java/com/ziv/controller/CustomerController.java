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

import com.ziv.models.Customer;
import com.ziv.repositories.CustomerRepository;


@RestController
@RequestMapping("/api/customers/")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping
	public List<Customer> list()
	{
		return customerRepository.findAll();
	}
	
	@GetMapping
	@RequestMapping("{id}")
	public Customer get(@PathVariable Integer id)
	{
		return customerRepository.getOne(id);
	}
	
	@PostMapping
	public  Customer create(@RequestBody final Customer customer)
	{
		return customerRepository.saveAndFlush(customer);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id)
	{
//		Also need to check for child records before deleting
		customerRepository.deleteById(id);
	}
	
	@RequestMapping(value="{id}",method = RequestMethod.PUT)
	public Customer update(@PathVariable Integer id, @RequestBody Customer customer)
	{
		//since it is PUT, all attributes are to be passed in. PATCH would need only those to be updated
		//TODO: add validation that all fields are passed in, else return 400
		Customer existingCustomer = customerRepository.getOne(id);
		BeanUtils.copyProperties(customer, existingCustomer,"customer_id");
		return customerRepository.saveAndFlush(existingCustomer);
	}
	
	
	
	
}
