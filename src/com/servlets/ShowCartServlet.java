package com.servlets;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dataBase.DataProcess;

/**
 * Servlet implementation class ShowCartServlet
 */
public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCartServlet() {
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
		//获取用户信息
		HttpSession session=request.getSession();
		String strName=(String)session.getAttribute("name1");
		//验证用户是否已经登录
		if(strName==null)//没有登录
		{
			request.setAttribute("mess", "请先登录！");
			RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			return;
		}
		//处理数据：从数据库中获取该用户的购物车信息
		String sql="select c.id,p.name,p.price,c.count,p.price*c.count from product p,cart c "
					+"where p.id=c.productID and c.userName='"+strName+"'";//p,c为别名
		System.out.println(sql+"---------------");
		DataProcess dataProcess=new DataProcess();                                                                                                                                                              
		Vector<Vector<String>>rows=dataProcess.getData(sql);//与数据链接获取数据那里一致
		request.setAttribute("product", rows);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cart_view.jsp");
		dispatcher.forward(request,response);
		
	}

}