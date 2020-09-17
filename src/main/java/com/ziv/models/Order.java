package com.ziv.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="orders")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer order_id;
	
	@Column(name="product_id")
	private Integer product_id;
	
	@Column(name="customer_id")
	private Integer customer_id;
	
	@Column(name="order_quantity")
	private Integer order_quantity;
	
	@Column(name="order_amount")
	private Float order_amount;
	
	@Column(name="order_date")
	private Date order_date;
	
	@Column(name="delivery_date")
	private Date delivery_date;
	
	
//	one order can have one or more products
//	one product can be in one or more orders
//	thus many to many here
	
//	@ManyToMany(mappedBy = "order")
//	@JoinColumn//(name = "product_id")
//	private List<Product> products;
	
//	@ManyToMany
//	@JoinTable(
//			name = "order_products",
//			joinColumns = @JoinColumn(name = "order_id"),
//			inverseJoinColumns = @JoinColumn(name = "product_id"))
//	private List<Product> products;
	
	
	
//	one order can have one customer
//	one customer can have multiple orders
//	thus one to one here
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(unique = true)

//	@ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name = "customer_id") //, referencedColumnName = "customer_id")
//	private Customer customer;
	
	public Order() {
		super();
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public Integer getOrder_quantity() {
		return order_quantity;
	}

	public void setOrder_quantity(Integer order_quantity) {
		this.order_quantity = order_quantity;
	}

	public Float getOrder_amount() {
		return order_amount;
	}

	public void setOrder_amount(Float order_amount) {
		this.order_amount = order_amount;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public Date getDelivery_date() {
		return delivery_date;
	}

	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}

//	public List<Product> getProducts() {
//		return products;
//	}
//
//	public void setProducts(List<Product> products) {
//		this.products = products;
//	}
//
//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
//
//	
	
	
}
