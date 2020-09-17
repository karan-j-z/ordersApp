package com.ziv.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="customers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customer_id;
	private String customer_name;
	private  Long customer_phone;
	private String customer_address;
	
//	one customer can have many orders
//	one order can have only one customer
//	thus one to many
	
//	@OneToMany
//	@JoinColumn(name = "order_id")
//	mappedBy is required in a bidirectional relationship to specify the field or property name of the owner entity of the relationship
	
//	@OneToMany(
//	        mappedBy = "customer",
//	        cascade = CascadeType.PERSIST,
//	        fetch = FetchType.LAZY
//	    )
//    private List<Order> orders;

	
	
	public Customer() {
		super();
	}

	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public Long getCustomer_phone() {
		return customer_phone;
	}

	public void setCustomer_phone(Long customer_phone) {
		this.customer_phone = customer_phone;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	
//	public List<Order> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(List<Order> orders) {
//		this.orders = orders;
//	}
//
//	

}
