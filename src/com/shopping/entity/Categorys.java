package com.shopping.entity;

public class Categorys {
	private int categoryID;
	private String category_name;
	private String category_desc;

	public Categorys(int categoryID) {
		super();
		this.categoryID = categoryID;
	}

	public Categorys(String category_name) {
		super();
		this.category_name = category_name;
	}

	public Categorys() {
		super();
	}

	public Categorys(String category_name, String category_desc) {
		super();
		this.category_name = category_name;
		this.category_desc = category_desc;
	}

	public Categorys(int categoryID, String category_name, String category_desc) {
		super();
		this.categoryID = categoryID;
		this.category_name = category_name;
		this.category_desc = category_desc;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getCategory_desc() {
		return category_desc;
	}

	public void setCategory_desc(String category_desc) {
		this.category_desc = category_desc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryID;
		result = prime * result + ((category_desc == null) ? 0 : category_desc.hashCode());
		result = prime * result + ((category_name == null) ? 0 : category_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categorys other = (Categorys) obj;
		if (categoryID != other.categoryID)
			return false;
		if (category_desc == null) {
			if (other.category_desc != null)
				return false;
		} else if (!category_desc.equals(other.category_desc))
			return false;
		if (category_name == null) {
			if (other.category_name != null)
				return false;
		} else if (!category_name.equals(other.category_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "categorys [categoryID=" + categoryID + ", category_name=" + category_name + ", category_desc="
				+ category_desc + "]";
	}

}
