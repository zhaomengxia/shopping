package com.shopping.listener;

import java.util.HashSet;
import java.util.function.IntConsumer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;


public class LoginUserListener implements ServletContextAttributeListener,HttpSessionAttributeListener{
	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		// TODO Auto-generated method stub
		
	}
//session创建后触发该方法，将session信息添加到集合中
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		
		System.out.print("-----有用户登录成功-----");
		
		//获得session信息
		HttpSession session=event.getSession();
		
		if(session!=null){
			//获得用户信息
		Object adminName=event.getValue();
		
		System.out.print(adminName);
		Object name=event.getName();
	Object name1=session.getAttribute("name");
	System.out.print(name1);
		System.out.print(name);
		//获得application信息
		ServletContext application=session.getServletContext();
		application.setAttribute("name", name);
		application.setAttribute("adminName", adminName);
		//从application中获得session列表
		HashSet<Object> loginCount=(HashSet<Object>)application.getAttribute("loginCount");	
		
			//判断数据列表是否为空 如果为空 需要实例化sessionlist；
		if(loginCount==null){
			application.setAttribute("loginCount", 1);
			loginCount=new HashSet<Object>();
			
		}
		else{
		//判断用户的session是否已经存在，如果已经存在不再添加
		loginCount.remove(adminName);//先删除，避免重复添加
		//将新增用户添加到list中。
		int i=1;
		
		loginCount.add(adminName);
		i++;
		application.setAttribute("loginCount", i);
		
		/*else{
			application.setAttribute("loginCount", Integer.parseInt(loginCount.toString())+1);
		}*/
		
		
		}
		}
	
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
				System.out.print("-----有用户退出登录-----");
				//获得session信息
				HttpSession session=event.getSession();
				
				if(session!=null){
					//获得用户信息
				Object adminName=event.getValue();
				
				System.out.print(adminName);
				Object name=event.getName();
			Object name1=session.getAttribute("name");
			System.out.print(name1);
				System.out.print(name);
				//获得application信息
				ServletContext application=session.getServletContext();
				application.setAttribute("name", name);
				application.setAttribute("adminName", adminName);
				//从application中获得session列表
				HashSet<Object> loginCount=(HashSet<Object>)application.getAttribute("loginCount");	
				
					//判断数据列表是否为空 如果为空 需要实例化sessionlist；
				if(loginCount!=null){
					
					loginCount.remove(adminName);
					
					application.setAttribute("loginCount", loginCount);
					
				}	
				
				}
			
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		System.out.print("loginCount");
		
	}


}
