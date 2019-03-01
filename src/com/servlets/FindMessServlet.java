package com.servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dataBase.DataProcess;

/**
 * Servlet implementation class FindMessServlet
 */
public class FindMessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindMessServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String book = request.getParameter("search");
		String sql;
		DataProcess dataProcess = new DataProcess();
		if(book==null || book.equals("")){
			response.sendRedirect("find.jsp");
			return;
		}
		sql = "select name,price,oneprice,img,date,face,body from product where name like'%"+book+"%'";
		Vector<Vector<String>> rows = (Vector<Vector<String>>)dataProcess.getData(sql);
		System.out.print(rows.size());
		request.setAttribute("book", rows);
		RequestDispatcher dispatcher = request.getRequestDispatcher("find.jsp");
		dispatcher.forward(request,response);
		}

}
