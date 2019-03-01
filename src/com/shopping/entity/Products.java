package com.shopping.entity;

import java.io.Serializable;
import java.util.Date;

public class Products implements Serializable{

	private int productID;
	private String product_name;
	private double income_price;
	private int providerID;
	private Providers provider;
	private int quantity;
	private double sales_price;
	private Categorys category;
	private int categoryID;

	private String income_time;
	private String filename;
	
	
	
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Products(int productID, String product_name, double income_price, int providerID, int quantity,
			double sales_price, int categoryID, String income_time) {
		super();
		this.productID = productID;
		this.product_name = product_name;
		this.income_price = income_price;
		this.providerID = providerID;
		this.quantity = quantity;
		this.sales_price = sales_price;
		this.categoryID = categoryID;
		this.income_time = income_time;
	}
	public Products(int productID, String product_name, double income_price, Providers provider, int quantity,
			double sales_price, Categorys category, String income_time, int providerID, int categoryID) {
		super();
		this.productID = productID;
		this.product_name = product_name;
		this.income_price = income_price;
		this.provider = provider;
		this.quantity = quantity;
		this.sales_price = sales_price;
		this.category = category;
		this.income_time = income_time;
		this.providerID = providerID;
		this.categoryID = categoryID;
	}
	public int getProviderID() {
		return providerID;
	}
	public void setProviderID(int providerID) {
		this.providerID = providerID;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getIncome_price() {
		return income_price;
	}
	public void setIncome_price(double income_price) {
		this.income_price = income_price;
	}
	public Providers getProvider() {
		return provider;
	}
	public void setProvider(Providers provider) {
		this.provider = provider;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getSales_price() {
		return sales_price;
	}
	public void setSales_price(double sales_price) {
		this.sales_price = sales_price;
	}
	public Categorys getCategory() {
		return category;
	}
	public void setCategory(Categorys category) {
		this.category = category;
	}
	
	public String getIncome_time() {
		return income_time;
	}
	public void setIncome_time(String income_time) {
		this.income_time = income_time;
	}

	
	public Products(int productID, String product_name, double income_price, Providers provider, int quantity,
			double sales_price, Categorys category, String income_time) {
		super();
		this.productID = productID;
		this.product_name = product_name;
		this.income_price = income_price;
		this.provider = provider;
		this.quantity = quantity;
		this.sales_price = sales_price;
		this.category = category;
		this.income_time = income_time;
	}
	public Products(String product_name, double income_price, Providers provider, int quantity, double sales_price,
			Categorys category, String income_time) {
		super();
		this.product_name = product_name;
		this.income_price = income_price;
		this.provider = provider;
		this.quantity = quantity;
		this.sales_price = sales_price;
		this.category = category;
		this.income_time = income_time;
	}
	public Products() {
		super();
	}
	@Override
	public String toString() {
		return "Products [productID=" + productID + ", product_name=" + product_name + ", income_price=" + income_price
				+ ", providerID=" + providerID + ", provider=" + provider + ", quantity=" + quantity + ", sales_price="
				+ sales_price + ", category=" + category + ", categoryID=" + categoryID + ", income_time=" + income_time
				+ ", filename=" + filename + "]";
	}
	public Products(int productID, String product_name, double income_price, int providerID, Providers provider,
			int quantity, double sales_price, Categorys category, int categoryID, String income_time, String filename) {
		super();
		this.productID = productID;
		this.product_name = product_name;
		this.income_price = income_price;
		this.providerID = providerID;
		this.provider = provider;
		this.quantity = quantity;
		this.sales_price = sales_price;
		this.category = category;
		this.categoryID = categoryID;
		this.income_time = income_time;
		this.filename = filename;
	}
	public Products(String product_name, double income_price, Providers provider, int quantity, double sales_price,
			Categorys category, String income_time, String filename) {
		super();
		this.product_name = product_name;
		this.income_price = income_price;
		this.provider = provider;
		this.quantity = quantity;
		this.sales_price = sales_price;
		this.category = category;
		this.income_time = income_time;
		this.filename = filename;
	}
	public Products(String product_name, double income_price, int providerID, int quantity, double sales_price,
			int categoryID, String income_time, String filename) {
		super();
		this.product_name = product_name;
		this.income_price = income_price;
		this.providerID = providerID;
		this.quantity = quantity;
		this.sales_price = sales_price;
		this.categoryID = categoryID;
		this.income_time = income_time;
		this.filename = filename;
	}
	
	
	
}
