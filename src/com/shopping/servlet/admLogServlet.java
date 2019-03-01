package com.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.entity.Admin;
import com.shopping.serviceimpl.AdminServiceImpl;

public class admLogServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String p=request.getParameter("p");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	if("login".equals(p)){
		doLogin(request, response);
	}else if("outlogin".equals(p)){
		dooutLogin(request, response);
	}else if("docheck".equals(p)){
		docheck(request, response);
	}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}
	protected void dooutLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session=request.getSession();
		session.setAttribute("loginuser", null) ;
		response.sendRedirect(request.getContextPath()+"/Myfirst.jsp");
	}

	
	
	
	
	protected void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//login.jsp中<input id="name" name="name" type="text" />的name
	String name1 = request.getParameter("name");
	//login.jsp中<input id="password" name="password" type="password" />的name属性值
	String password1 = request.getParameter("password");
	//输出流
	PrintWriter out=response.getWriter();
	Admin admin = new Admin(name1, password1);
	AdminServiceImpl service = new AdminServiceImpl();
	
	boolean result = service.login(admin);
	//String str = null;
	//Date 时间类
		Date date = new Date();
		//设置时间输出格式
		SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	if (result) {
		//str = session.getId();
		Cookie cook = null;
		Cookie[] cookie1 = request.getCookies();
		if (cookie1 != null) {
			for (Cookie c : cookie1) {
				if (c.getName().equals("logintime2")) {
					Cookie cooki = new Cookie("logintime1", c.getValue());
					c.setPath("/shop");
					c.setMaxAge(60 * 10);
					response.addCookie(cooki);

				}
				cook = new Cookie("logintime2", date1.format(date));

				cook.setMaxAge(60 * 60);
				cook.setPath("/shop");
				response.addCookie(cook);

			}

		}

	}
	
	Cookie[] cookie = request.getCookies();
	if (cookie != null) {
		for (int i = 0; i < cookie.length; i++) {
			if (cookie[i].getName().equals("logintime1")) {
			
				out.println("LastAccessTime:"+cookie[i].getValue());
			}

		}
				//out.print(date1);
		HttpSession session=request.getSession();
		admin = service.selctByname(name1);
		String name=admin.getName();
		session.setAttribute("loginuser", admin);
		//session.setAttribute("names", name);
		//当前项目的根目录，response.sendRedirect重定向实现跳转页面不能传递对象数据，只能通过？传递字符串或则数值数据，使用request.getContextPath()获得根目录，地址栏是会变的，因为它相当于地址栏重新输入了一个地址，再次向服务器发送了一个请求
		//通过	request.getRequestDispatcher("").forward(request, response);转发实现页面跳转，可以传递对象数据，对象数据要放在	request.setAttribute("name", name);里，不要忘记调用forward实现request对象数据传递和页面跳转，不要加request.getContextPath()因为/就代表项目的根目录，地址栏不变，因为他是在服务端执行。
	
	
		response.sendRedirect(request.getContextPath() + "/Admin/indexadmin.jsp");

	}

	else {
		out.print("<script>alert('登录失败');location.href='/Admin/loginadmin.jsp'</script>");

	}
	//session.setAttribute("sid", str);
	}
	
	
	protected void docheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	HttpSession session=request.getSession();
	Admin admin=(Admin)session.getAttribute("loginuser");
	if(admin==null){
		response.sendRedirect(request.getContextPath()+"/Admin/loginadmin.jsp");
		return;
	}
	else{
	request.setAttribute("admin", admin);
	request.getRequestDispatcher("/Admin/right.jsp").forward(request, response);
	}
	}
}
