package com.shopping.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class cookieDemo extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter pw=resp.getWriter();
		pw.write("您上次登陆的时间是：");
		Cookie[] cookie=req.getCookies();
		for(int i=0;cookie!=null&&i<cookie.length;i++){
			if(cookie[i].equals("LastAccesstime")){
				
				long cookieValue=Long.parseLong(cookie[i].getValue());
				Date date=new Date(cookieValue);
				pw.write(date.toLocaleString());
				
			}
			
		}
		Cookie cooki=new Cookie("LastAccessTime",System.currentTimeMillis()+"");
		cooki.setMaxAge(60);
		resp.addCookie(cooki);
		
		
	}
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		super.doPost(req, resp);
	}

}
