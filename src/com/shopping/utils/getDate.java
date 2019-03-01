package com.shopping.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class getDate {
/*
 *�����ڶ���ת��Ϊ�ض������ڸ�ʽ�ַ���
 *date Ҫת��������
 *fomatstrҪת��Ϊ���ض������ڸ�ʽyy-MM-dd HH:mm:ss
 *����ת������ַ���
 */
	
	public static String getStrByDate(Date date,String fomatstr){
		
		//date=new Date();
		SimpleDateFormat date1=new SimpleDateFormat(fomatstr);
		return date1.format(date);
		
	}
	/*���ַ���ת��Ϊ���ڶ���
	 * datestrҪת�����ַ���
	 * fomatstrת��Ϊ�����ڸ�ʽ
	 * ����ת���������
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
