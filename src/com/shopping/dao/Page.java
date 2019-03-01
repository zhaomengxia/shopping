package com.shopping.dao;

import java.util.List;

public class Page<T> {
	private int PageSize;//ÿҳ��¼��
	private int currentPage;//ҳ��
	private int total;// �ܼ�¼��
	private int totalPage;
	private int firstPage;
	private int upPage;
	private int downPage;
	private int nowPage;
	private List<T> list;//��ż�¼

	// ��ҳ
	public int getFirstPage() {
		return 1;
	}

	// ��ҳ��
	public int getTotalPage() {
		return (total + PageSize - 1) / PageSize;
		
	}
	// βҳ

	public int lastPage() {
		return getTotalPage();
	}

	// ��һҳ
	public int getUpPage() {
		if (currentPage == 1) {
			return 1;
		} else {
			return currentPage - 1;
		}
	}
	// ��һҳ
	public int getDownPage() {
		if (currentPage == lastPage()) {
			return currentPage;
		} else {
			return currentPage + 1;
		}

	}

	// �ڼ�ҳ
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
