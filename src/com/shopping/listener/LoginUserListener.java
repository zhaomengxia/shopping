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
//session�����󴥷��÷�������session��Ϣ��ӵ�������
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		
		System.out.print("-----���û���¼�ɹ�-----");
		
		//���session��Ϣ
		HttpSession session=event.getSession();
		
		if(session!=null){
			//����û���Ϣ
		Object adminName=event.getValue();
		
		System.out.print(adminName);
		Object name=event.getName();
	Object name1=session.getAttribute("name");
	System.out.print(name1);
		System.out.print(name);
		//���application��Ϣ
		ServletContext application=session.getServletContext();
		application.setAttribute("name", name);
		application.setAttribute("adminName", adminName);
		//��application�л��session�б�
		HashSet<Object> loginCount=(HashSet<Object>)application.getAttribute("loginCount");	
		
			//�ж������б��Ƿ�Ϊ�� ���Ϊ�� ��Ҫʵ����sessionlist��
		if(loginCount==null){
			application.setAttribute("loginCount", 1);
			loginCount=new HashSet<Object>();
			
		}
		else{
		//�ж��û���session�Ƿ��Ѿ����ڣ�����Ѿ����ڲ������
		loginCount.remove(adminName);//��ɾ���������ظ����
		//�������û���ӵ�list�С�
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
				System.out.print("-----���û��˳���¼-----");
				//���session��Ϣ
				HttpSession session=event.getSession();
				
				if(session!=null){
					//����û���Ϣ
				Object adminName=event.getValue();
				
				System.out.print(adminName);
				Object name=event.getName();
			Object name1=session.getAttribute("name");
			System.out.print(name1);
				System.out.print(name);
				//���application��Ϣ
				ServletContext application=session.getServletContext();
				application.setAttribute("name", name);
				application.setAttribute("adminName", adminName);
				//��application�л��session�б�
				HashSet<Object> loginCount=(HashSet<Object>)application.getAttribute("loginCount");	
				
					//�ж������б��Ƿ�Ϊ�� ���Ϊ�� ��Ҫʵ����sessionlist��
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
