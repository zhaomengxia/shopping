package com.shopping.listener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.activation.DataHandler;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.shopping.utils.getDate;

public class mylitener implements ServletContextListener{
	private Timer timer;
	private MyTask mytask;
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		timer=new Timer();
		mytask=new MyTask();
		timer.schedule(mytask, 0,3000);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		timer.cancel();
		System.out.print("-----定时任务结束----------");
		
	}

 class MyTask extends TimerTask{
		
		@Override
		public void run() {
			Date date = new Date();
			SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
			System.out.print(date1.format(date));
			System.out.print(date1.format(date)+"任务开始执行----");
			
		}
	}


}
