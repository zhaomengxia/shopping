package com.shopping.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineUserListener implements HttpSessionListener {

	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.print("有用户上线了");
		ServletContext application=se.getSession().getServletContext();
		//因为count第一个值是null，所以要判断再执行
		Object count=application.getAttribute("count");
		if(count==null){
			application.setAttribute("count", 1);
		}else{
			application.setAttribute("count", Integer.parseInt(count.toString())+1);
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		//当用户关闭浏览器时执行
		System.out.print("有用户下线了");
		ServletContext application=se.getSession().getServletContext();
		//先得到count值，再给count加1
		Object count=application.getAttribute("count");
		if(count!=null&&(Integer)count!=0){
			application.setAttribute("count", Integer.parseInt(count.toString())-1);
			
		}
		
	}

}
