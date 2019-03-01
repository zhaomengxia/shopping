package com.shopping.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class test {

	public static void main(String[] args) throws ServletException, IOException {
		// TODO Auto-generated method stub

		cookieDemo cookie=new cookieDemo();
		
		HttpServletRequest req = null;
		HttpServletResponse resp = null;
		cookie.doPost(req, resp);
	}

}
