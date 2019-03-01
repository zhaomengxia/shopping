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
public class ManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageServlet() {
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
	
		//接收数据
		request.setCharacterEncoding("utf-8");
		//String Sex3=request.getParameter("id");	
		String userName=request.getParameter("name");//userName的值与jsp界面的参数一直
		String Sex2=request.getParameter("sort");	
		String Password1=request.getParameter("price");
		String Password2=request.getParameter("oneprice");
		String Sex=request.getParameter("img");
		String Password=request.getParameter("date");
		String Sex1=request.getParameter("sale");
		String Password3=request.getParameter("face");
		String Password4=request.getParameter("body");
		String Password5=request.getParameter("length");
		String Password6=request.getParameter("quantity");
		String Password7=request.getParameter("source");
		
		//验证数据（空验证 验证格式是否正确）
		if(userName==null || userName.equals("") 
				||Password1==null || Password1.equals("")
				||Password2==null || Password2.equals("")
				||Password==null || Password.equals("")
				||Sex1==null || Sex1.equals("")
				||Password3==null || Password3.equals("")
				||Password4==null || Password4.equals("")
				){
			request.setAttribute("mess", "不能为空!");
			RequestDispatcher dispatcher=request.getRequestDispatcher("manager/addBook.jsp");
			dispatcher.forward(request, response);
			return;
		}
		//判断密码是否一致
		
		//用户是否存在
		String sql="select * from product where name='"+userName+"'";
		DataProcess dataProcess=new DataProcess();
		Vector<Vector<String>> rows=dataProcess.getData(sql);
		if(rows.size()>0){
			request.setAttribute("mess", "已存在");
	    	RequestDispatcher dispatcher=request.getRequestDispatcher("manager/addBook.jsp");
	    	dispatcher.forward(request, response);
	    	return;
		}
		
		String insertSql="insert into product values('"+userName+"','"+Sex2+"','"+Password1+"','"+Password2+"','"+Sex+"','"+Password+"','"+Sex1+"','"+Password3+"','"+Password4+"','"+Password5+"','"+Password6+"','"+Password7+"')";
		
		boolean b=dataProcess.update(insertSql);
	    if(!b){
	    	request.setAttribute("mess", "添加失败！！");
	    	RequestDispatcher dispatcher=request.getRequestDispatcher("manager/addBook.jsp");
	    	dispatcher.forward(request, response);
	    	return;
	    }    
	    
	    response.sendRedirect("/manager/addBook.jsp");
	    /*response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print("用户名："+userName+"<br />"+"密码：" + Password+"<br />"+"确认密码：" + Password1+ "<br />"+"性别：" +Sex+ "<br />"+"兴趣爱好：" +Interest);*/
		
		
	}

}

	