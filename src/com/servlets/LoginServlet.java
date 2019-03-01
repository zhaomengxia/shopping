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
		//��������
		request.setCharacterEncoding("utf-8");
		String strName=request.getParameter("name1");
		String strPwd=request.getParameter("password2");
		HttpSession session=request.getSession();
		//��֤����
		if(strName==null||strName.equalsIgnoreCase("")||strPwd==null||strPwd.equals("")){
			request.setAttribute("mess", "����Ϊ�գ�");
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

		//��������
		String sql="select * from userinfo where username='"+strName+"' and password='"+strPwd+"' ";//�����ݿ��в�ѯusername��password�ļ�¼
		DataProcess dataProcess=new DataProcess();
		Vector<Vector<String>>rows= dataProcess.getData(sql);//ǰ�����������ͣ�rows�����ݼ�¼�ļ���
		
		//��½�ɹ�
		if(rows.size()>0){
			
			session.setAttribute("name1", strName);
			
			response.sendRedirect("index.jsp");
			return;
		}
		//��½���ɹ�
		request.setAttribute("mess", "�û��������벻��ȷ��");
		RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
		
	}

}
