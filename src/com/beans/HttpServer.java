package com.beans;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.squareup.okhttp.*;
public class HttpServer { 
	 public static void main(String[] args) {
	        final String[] str = {""};

	        final boolean[] flag = {false};

	        //创建okHttpClient对象
	        OkHttpClient mOkHttpClient = new OkHttpClient();
	        //创建一个Request
	        final Request request = new Request.Builder()
	                .url("http://114.55.41.77:8000/Common.aspx?method=GetJson&methodName=GetGoods&page=1&size=10&paras=%E7%9B%B8%E5%9F%8E%E5%8C%BA%E9%98%B2%E6%B1%9B%E4%BB%93%E5%BA%93,%E6%8E%92%E6%B6%9D%E6%9C%BA%E5%85%B7")
	                .build();
	        //new call
	        Call call = mOkHttpClient.newCall(request);
	        //请求加入调度
	        call.enqueue(new Callback() {
	            @Override
	            public void onFailure(Request request, IOException e) {
	            }

	            @Override
	            public void onResponse(final Response response) throws IOException {
	                String htmlStr = response.body().string();
	                 //把json文本parse成JSONObject
	                JSONObject parse = (JSONObject)JSON.parse(htmlStr);
	             
	                //将javaBean序列化为JSON文本
	                String data = JSON.toJSONString(parse.get("Data"));
	                
	                JSONObject parse1 = (JSONObject)JSON.parse(data);
	                
	                String list = JSON.toJSONString(parse1.get("list"));
	                
	                List<? extends Meng> mengs = JSON.parseArray(list, Meng.class);

	                for (Meng meng1:
	                mengs) {
	                    System.out.println(meng1.toString());
	                }

	                System.out.println(htmlStr + "************************************");
	                str[0] = htmlStr;
	                flag[0] = true;
	            }
	        });

	        while (!flag[0]) {
//	            System.out.println(true);
	        }

	        call.cancel();

	    }
}