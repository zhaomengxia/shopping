package com.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dataBase.DataProcess;

/**
 * Servlet implementation class ShowProductServlet
 */
public class ShowProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProductServlet() {
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
		//��������
		
		//��֤����
		//��������
		//�����ݿ����ȡ��Ʒ��Ϣ
		String sql="select id,name,price,img,sale from product"; //where id<=12
		
		DataProcess data=new DataProcess();
		Vector<Vector<String>> product=data.getData(sql);//vector�Ƕ�ά����
		
		request.setAttribute("product",product);//��request��ȡ��Ϣ
		RequestDispatcher dispatcher=request.getRequestDispatcher("product.jsp");//��Ϊ�����ݴ洢��request�����Ҫת��
		dispatcher.forward(request, response);
		
		
		
	}

}
