package com.shopping.entity;

public class Order_detail {
	private int id;
	private String orderID;
	private Products products;
	private int quantity;
	private int discount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public Products getProducts() {
		return products;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	public Order_detail() {
		super();
	}
	public Order_detail(int id, String orderID, Products products, int quantity, int discount) {
		super();
		this.id = id;
		this.orderID = orderID;
		this.products = products;
		this.quantity = quantity;
		this.discount = discount;
	}
	public Order_detail(String orderID, Products products, int quantity, int discount) {
		super();
		this.orderID = orderID;
		this.products = products;
		this.quantity = quantity;
		this.discount = discount;
	}
	
	
	
	public Order_detail(Products products, int quantity, int discount) {
		super();
		this.products = products;
		this.quantity = quantity;
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "Order_detail [id=" + id + ", orderID=" + orderID + ", products=" + products + ", quantity=" + quantity
				+ ", discount=" + discount + "]";
	}
	
	
	

}
