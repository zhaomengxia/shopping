package com.beans;

public class Product {
		private int id;
		private String name;
		private float sort;
		private float price;
		private float oneprice;
		private String img;//Ð¡
		private String date;
		private float sale;
		private String face;
		private String body;
		private String length;
		private String quantity;
		private String source;//´óÍ¼Æ¬
		
		
		public Product() {
			super();
		}
		public Product(int id, String name, float sort, float price,
				float oneprice, String img, String date, float sale,
				String face, String body, String length, String quantity,
				String source) {
			super();
			this.id = id;
			this.name = name;
			this.sort = sort;
			this.price = price;
			this.oneprice = oneprice;
			this.img = img;
			this.date = date;
			this.sale = sale;
			this.face = face;
			this.body = body;
			this.length = length;
			this.quantity = quantity;
			this.source = source;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public float getSort() {
			return sort;
		}
		public void setSort(float sort) {
			this.sort = sort;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		public float getOneprice() {
			return oneprice;
		}
		public void setOneprice(float oneprice) {
			this.oneprice = oneprice;
		}
		public String getImg() {
			return img;
		}
		public void setImg(String img) {
			this.img = img;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public float getSale() {
			return sale;
		}
		public void setSale(float sale) {
			this.sale = sale;
		}
		public String getFace() {
			return face;
		}
		public void setFace(String face) {
			this.face = face;
		}
		public String getBody() {
			return body;
		}
		public void setBody(String body) {
			this.body = body;
		}
		public String getLength() {
			return length;
		}
		public void setLength(String length) {
			this.length = length;
		}
		public String getQuantity() {
			return quantity;
		}
		public void setQuantity(String quantity) {
			this.quantity = quantity;
		}
		public String getSource() {
			return source;
		}
		public void setSource(String source) {
			this.source = source;
		}
		

}
