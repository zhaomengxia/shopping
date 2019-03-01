package com.shopping.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.entity.Admin;

public class checkLoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.print("过滤初始");
	}

	@Override
	public void doFilter(ServletRequest request1, ServletResponse response1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)request1;
		HttpServletResponse response=(HttpServletResponse)response1;
		String uri=request.getRequestURI();
		uri=uri.toLowerCase();
		System.out.print(uri);
		System.out.print("登录过滤");
		
		HttpSession session=request.getSession();
		Object admin=session.getAttribute("loginuser");
		
		if(admin==null){
			
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
		else{
			chain.doFilter(request, response);
		}
		
		System.out.println("过滤结束");
			
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.print("过滤销毁");
	}

}
