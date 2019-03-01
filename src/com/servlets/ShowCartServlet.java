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
		//�������ݣ������ݿ��л�ȡ���û��Ĺ��ﳵ��Ϣ
		String sql="select c.id,p.name,p.price,c.count,p.price*c.count from product p,cart c "
					+"where p.id=c.productID and c.userName='"+strName+"'";//p,cΪ����
		System.out.println(sql+"---------------");
		DataProcess dataProcess=new DataProcess();                                                                                                                                                              
		Vector<Vector<String>>rows=dataProcess.getData(sql);//���������ӻ�ȡ��������һ��
		request.setAttribute("product", rows);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cart_view.jsp");
		dispatcher.forward(request,response);
		
	}

}