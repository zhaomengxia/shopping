package com.shopping.dao;

import java.util.List;

public class Page<T> {
	private int PageSize;//每页记录数
	private int currentPage;//页数
	private int total;// 总记录数
	private int totalPage;
	private int firstPage;
	private int upPage;
	private int downPage;
	private int nowPage;
	private List<T> list;//存放记录

	// 首页
	public int getFirstPage() {
		return 1;
	}

	// 总页数
	public int getTotalPage() {
		return (total + PageSize - 1) / PageSize;
		
	}
	// 尾页

	public int lastPage() {
		return getTotalPage();
	}

	// 上一页
	public int getUpPage() {
		if (currentPage == 1) {
			return 1;
		} else {
			return currentPage - 1;
		}
	}
	// 下一页
	public int getDownPage() {
		if (currentPage == lastPage()) {
			return currentPage;
		} else {
			return currentPage + 1;
		}

	}

	// 第几页
	public int getNowPage() {
		if (currentPage <= lastPage() && currentPage > 0) {
			return currentPage;
		} else {
			return 1;
		}
	}

	public Page(int currentPage, int Pagesize) {
		this.currentPage = currentPage;
		this.PageSize = Pagesize;
	}

	public int getPageSize() {
		return PageSize;
	}

	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
