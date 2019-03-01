package com.shopping.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineUserListener implements HttpSessionListener {

	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.print("���û�������");
		ServletContext application=se.getSession().getServletContext();
		//��Ϊcount��һ��ֵ��null������Ҫ�ж���ִ��
		Object count=application.getAttribute("count");
		if(count==null){
			application.setAttribute("count", 1);
		}else{
			application.setAttribute("count", Integer.parseInt(count.toString())+1);
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		//���û��ر������ʱִ��
		System.out.print("���û�������");
		ServletContext application=se.getSession().getServletContext();
		//�ȵõ�countֵ���ٸ�count��1
		Object count=application.getAttribute("count");
		if(count!=null&&(Integer)count!=0){
			application.setAttribute("count", Integer.parseInt(count.toString())-1);
			
		}
		
	}

}
