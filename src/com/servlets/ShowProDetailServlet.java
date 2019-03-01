package com.servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Product;
import com.dataBase.DataProcess;

/**
 * Servlet implementation class ShowProDatailServlet
 */
public class ShowProDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//接收数据
		String id=request.getParameter("id");
		//验证数据
		//处理数据:从数据库获取id的对应的商品信息
		String sql="select * from product where id="+id;
		DataProcess data=new DataProcess();
		Vector rows=data.getData(sql);//一条记录
		Vector row=(Vector)rows.get(0);//String
		
		Product product=new Product();
		product.setId(Integer.parseInt((String)row.get(0)));
		product.setName((String)row.get(1));
		product.setSort(Float.parseFloat((String)row.get(2)));
		product.setPrice(Float.parseFloat((String)row.get(3)));
		product.setOneprice(Float.parseFloat((String)row.get(4)));
		product.setImg((String)row.get(5));
		product.setDate((String)row.get(6));
		product.setSale(Float.parseFloat((String)row.get(7)));
		product.setFace((String)row.get(8));
		product.setBody((String)row.get(9));
		product.setLength((String)row.get(10));
		product.setQuantity((String)row.get(11));
		product.setSource((String)row.get(12));
		
		request.setAttribute("product", product);
		RequestDispatcher dispatcher=request.getRequestDispatcher("item.jsp");
		dispatcher.forward(request, response);
		
	}

}
