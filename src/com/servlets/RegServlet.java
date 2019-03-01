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
		//��������
		request.setCharacterEncoding("utf-8");
		String userName=request.getParameter("userName");//userName��ֵ��jsp����Ĳ���һֱ
		String Password=request.getParameter("password");
		String Password1=request.getParameter("password1");
		String Sex=request.getParameter("sex");
		String Address=request.getParameter("address");
		String Phone=request.getParameter("phone");
		/*int roleid=Integer.parseInt(request.getParameter("roleid"));*/
		//��֤���ݣ�����֤ ��֤��ʽ�Ƿ���ȷ��
		if(userName==null || userName.equals("") 
				||Password==null || Password.equals("")
				||Password1==null || Password1.equals("")
				||Sex==null || Sex.equals("")
				||Address==null || Address.equals("")||Phone==null || Phone.equals("")){
			request.setAttribute("mess", "����Ϊ��!");
			RequestDispatcher dispatcher=request.getRequestDispatcher("reg.jsp");
			dispatcher.forward(request, response);
			return;
		}
		//�ж������Ƿ�һ��
		if(!Password.equals(Password1)){
			request.setAttribute("mess", "���벻һ��!");
			RequestDispatcher dispatcher=request.getRequestDispatcher("reg.jsp");
			dispatcher.forward(request, response);
			return;
			
		}
		//�û��Ƿ����
		String sql="select * from userinfo where username='"+userName+"'";
		DataProcess dataProcess=new DataProcess();
		Vector<Vector<String>> rows=dataProcess.getData(sql);
		if(rows.size()>0){
			request.setAttribute("mess", "�û��Ѵ���");
	    	RequestDispatcher dispatcher=request.getRequestDispatcher("reg.jsp");
	    	dispatcher.forward(request, response);
	    	return;
		}
		//�������ݣ���ʾע����Ϣ			
	
		String insertSql="insert into userinfo(userName,password,sex,address,phone)values('"+userName+"','"+Password+"','"+Sex+"','"+Address+"','"+Phone+"')";
		
		boolean b=dataProcess.update(insertSql);
		System.out.println(b+"hhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
	    if(!b){
	    	request.setAttribute("mess", "ע�᲻�ɹ�");
	    	RequestDispatcher dispatcher=request.getRequestDispatcher("reg.jsp");
	    	dispatcher.forward(request, response);
	    	return;
	    }    
	    //ע��ɹ� 
	    response.sendRedirect("login.jsp");
	    /*response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print("�û�����"+userName+"<br />"+"���룺" + Password+"<br />"+"ȷ�����룺" + Password1+ "<br />"+"�Ա�" +Sex+ "<br />"+"��Ȥ���ã�" +Interest);*/
		
		
	}

}

	