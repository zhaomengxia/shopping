package com.shopping.entity;

public class Orders {
private String orderID;
private String order_date;
private Customers customers;
private Employ employ;

public String getOrderID() {
	return orderID;
}
public void setOrderID(String orderID) {
	this.orderID = orderID;
}
public String getOrder_date() {
	return order_date;
}
public void setOrder_date(String order_date) {
	this.order_date = order_date;
}
public Customers getCustomers() {
	return customers;
}
public void setCustomers(Customers customers) {
	this.customers = customers;
}
public Employ getEmploy() {
	return employ;
}
public void setEmploy(Employ employ) {
	this.employ = employ;
}
public Orders() {
	super();
}

public Orders(String orderID, String order_date, Customers customers, Employ employ) {
	super();
	this.orderID = orderID;
	this.order_date = order_date;
	this.customers = customers;
	this.employ = employ;
}



public Orders(String order_date, Customers customers, Employ employ) {
	super();
	this.order_date = order_date;
	this.customers = customers;
	this.employ = employ;
}
@Override
public String toString() {
	return "Orders [orderID=" + orderID + ", order_date=" + order_date + ", customers=" + customers + ", employ="
			+ employ + "]";
}


	
}
