package com.ziv.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="products")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer product_id;
	private String product_name;
	private String product_description;
	private Float product_price;
	private Integer product_quantity;
	
//	one product can be in one or more orders
//	one order can have one or more products
//	thus many to many here
	
//	@ManyToMany(mappedBy = "products")
//    private List<Order> orders;
//	

	
	public Product() {
		super();
	}
	
	
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public Float getProduct_price() {
		return product_price;
	}
	public void setProduct_price(Float product_price) {
		this.product_price = product_price;
	}
	public Integer getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(Integer product_quantity) {
		this.product_quantity = product_quantity;
	}


//	public List<Order> getOrders() {
//		return orders;
//	}
//
//
//	public void setOrders(List<Order> orders) {
//		this.orders = orders;
//	}


	

}
