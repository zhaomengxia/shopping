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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		//接受数据
		request.setCharacterEncoding("utf-8");
		String strName=request.getParameter("name1");
		String strPwd=request.getParameter("password2");
		HttpSession session=request.getSession();
		//验证数据
		if(strName==null||strName.equalsIgnoreCase("")||strPwd==null||strPwd.equals("")){
			request.setAttribute("mess", "不能为空！");
			RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			return;
			}
		if(strName.equals("admin")){
			if(strName.equals("admin")&&strPwd.equals("admin")){
				session.setAttribute("name1",strName);
				response.sendRedirect("ManageServlet");
				return;
			}
		}

		//处理数据
		String sql="select * from userinfo where username='"+strName+"' and password='"+strPwd+"' ";//在数据库中查询username和password的记录
		DataProcess dataProcess=new DataProcess();
		Vector<Vector<String>>rows= dataProcess.getData(sql);//前面试数据类型，rows是数据记录的集合
		
		//登陆成功
		if(rows.size()>0){
			
			session.setAttribute("name1", strName);
			
			response.sendRedirect("index.jsp");
			return;
		}
		//登陆不成功
		request.setAttribute("mess", "用户名或密码不正确！");
		RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
		
	}

}
