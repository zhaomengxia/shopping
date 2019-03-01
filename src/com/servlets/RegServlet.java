package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dataBase.DataProcess;

/**
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
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
		request.setCharacterEncoding("utf-8");
		String userName=request.getParameter("userName");//userName的值与jsp界面的参数一直
		String Password=request.getParameter("password");
		String Password1=request.getParameter("password1");
		String Sex=request.getParameter("sex");
		String Address=request.getParameter("address");
		String Phone=request.getParameter("phone");
		/*int roleid=Integer.parseInt(request.getParameter("roleid"));*/
		//验证数据（空验证 验证格式是否正确）
		if(userName==null || userName.equals("") 
				||Password==null || Password.equals("")
				||Password1==null || Password1.equals("")
				||Sex==null || Sex.equals("")
				||Address==null || Address.equals("")||Phone==null || Phone.equals("")){
			request.setAttribute("mess", "不能为空!");
			RequestDispatcher dispatcher=request.getRequestDispatcher("reg.jsp");
			dispatcher.forward(request, response);
			return;
		}
		//判断密码是否一致
		if(!Password.equals(Password1)){
			request.setAttribute("mess", "密码不一致!");
			RequestDispatcher dispatcher=request.getRequestDispatcher("reg.jsp");
			dispatcher.forward(request, response);
			return;
			
		}
		//用户是否存在
		String sql="select * from userinfo where username='"+userName+"'";
		DataProcess dataProcess=new DataProcess();
		Vector<Vector<String>> rows=dataProcess.getData(sql);
		if(rows.size()>0){
			request.setAttribute("mess", "用户已存在");
	    	RequestDispatcher dispatcher=request.getRequestDispatcher("reg.jsp");
	    	dispatcher.forward(request, response);
	    	return;
		}
		//处理数据，显示注册信息			
	
		String insertSql="insert into userinfo(userName,password,sex,address,phone)values('"+userName+"','"+Password+"','"+Sex+"','"+Address+"','"+Phone+"')";
		
		boolean b=dataProcess.update(insertSql);
		System.out.println(b+"hhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
	    if(!b){
	    	request.setAttribute("mess", "注册不成功");
	    	RequestDispatcher dispatcher=request.getRequestDispatcher("reg.jsp");
	    	dispatcher.forward(request, response);
	    	return;
	    }    
	    //注册成功 
	    response.sendRedirect("login.jsp");
	    /*response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print("用户名："+userName+"<br />"+"密码：" + Password+"<br />"+"确认密码：" + Password1+ "<br />"+"性别：" +Sex+ "<br />"+"兴趣爱好：" +Interest);*/
		
		
	}

}

	