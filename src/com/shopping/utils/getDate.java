package com.shopping.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class getDate {
/*
 *把日期对象转化为特定的日期格式字符串
 *date 要转化的日期
 *fomatstr要转化为的特定的日期格式yy-MM-dd HH:mm:ss
 *返回转化后的字符串
 */
	
	public static String getStrByDate(Date date,String fomatstr){
		
		//date=new Date();
		SimpleDateFormat date1=new SimpleDateFormat(fomatstr);
		return date1.format(date);
		
	}
	/*把字符串转化为日期对象
	 * datestr要转化的字符串
	 * fomatstr转化为的日期格式
	 * 返回转化后的日期
	 */
	public static Date getDateBystr(String datestr,String fomatstr){
		Date date=null;
		SimpleDateFormat date1=new SimpleDateFormat(fomatstr);
		try {
			date=date1.parse(datestr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return date;
	}
	public static String getFilename(String ext){
		String filename="";
		
		filename=getStrByDate(new Date(),"yyyyMMdd");
		
		for(int i=0;i<4;i++){
			int num=(int)(Math.random()*10);
			filename=filename+num;
		}
		filename=filename+ext;
		return filename;
	}
	
	
}
