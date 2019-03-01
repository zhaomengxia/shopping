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
		
		//��ȡ�û���Ϣ
				HttpSession session=request.getSession();
				String strName=(String)session.getAttribute("name1");
				//��֤�û��Ƿ��Ѿ���¼
				if(strName==null)//û�е�¼
				{
					request.setAttribute("mess", "���ȵ�¼��");
					RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);
					
					return;
				}
	
		//��������
		request.setCharacterEncoding("utf-8");
		//String Sex3=request.getParameter("id");	
		String userName=request.getParameter("name");//userName��ֵ��jsp����Ĳ���һֱ
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
		
		//��֤���ݣ�����֤ ��֤��ʽ�Ƿ���ȷ��
		if(userName==null || userName.equals("") 
				||Password1==null || Password1.equals("")
				||Password2==null || Password2.equals("")
				||Password==null || Password.equals("")
				||Sex1==null || Sex1.equals("")
				||Password3==null || Password3.equals("")
				||Password4==null || Password4.equals("")
				){
			request.setAttribute("mess", "����Ϊ��!");
			RequestDispatcher dispatcher=request.getRequestDispatcher("manager/addBook.jsp");
			dispatcher.forward(request, response);
			return;
		}
		//�ж������Ƿ�һ��
		
		//�û��Ƿ����
		String sql="select * from product where name='"+userName+"'";
		DataProcess dataProcess=new DataProcess();
		Vector<Vector<String>> rows=dataProcess.getData(sql);
		if(rows.size()>0){
			request.setAttribute("mess", "�Ѵ���");
	    	RequestDispatcher dispatcher=request.getRequestDispatcher("manager/addBook.jsp");
	    	dispatcher.forward(request, response);
	    	return;
		}
		
		String insertSql="insert into product values('"+userName+"','"+Sex2+"','"+Password1+"','"+Password2+"','"+Sex+"','"+Password+"','"+Sex1+"','"+Password3+"','"+Password4+"','"+Password5+"','"+Password6+"','"+Password7+"')";
		
		boolean b=dataProcess.update(insertSql);
	    if(!b){
	    	request.setAttribute("mess", "���ʧ�ܣ���");
	    	RequestDispatcher dispatcher=request.getRequestDispatcher("manager/addBook.jsp");
	    	dispatcher.forward(request, response);
	    	return;
	    }    
	    
	    response.sendRedirect("/manager/addBook.jsp");
	    /*response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print("�û�����"+userName+"<br />"+"���룺" + Password+"<br />"+"ȷ�����룺" + Password1+ "<br />"+"�Ա�" +Sex+ "<br />"+"��Ȥ���ã�" +Interest);*/
		
		
	}

}

	