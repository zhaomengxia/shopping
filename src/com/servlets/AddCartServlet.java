package com.servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Product;
import com.dataBase.DataProcess;

/**
 * Servlet implementation class AddCart
 */
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
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
		int productID=Integer.parseInt(request.getParameter("id"));
		int count=Integer.parseInt(request.getParameter("quantity"));
		
		HttpSession session=request.getSession();
		String userName=(String)session.getAttribute("name1");
		System.out.println(userName+"----------------9999");
		String sql="insert into cart(productID,count,userName)values('"+productID+"','"+count+"','"+userName+"')";
		System.out.println(sql+"--------------------------");
		DataProcess dataProcess=new DataProcess();                                                                                                                                                              
		boolean t=dataProcess.update(sql);
		/*Vector<Vector<String>> rows=dataProcess.getData(sql);//与数据链接获取数据那里一致
		request.setAttribute("product", rows);
		*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("ShowCartServlet");
		
		dispatcher.forward(request,response);
		
	}

}
