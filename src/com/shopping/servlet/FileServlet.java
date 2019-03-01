package com.shopping.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.shopping.entity.Files;
import com.shopping.serviceimpl.FileServiceImpl;
import com.shopping.utils.getDate;

public class FileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String p=request.getParameter("p");
		
		System.out.println(p);
		if("doUpFile".equals(p)){
			doUpFile(request, response);
		}else if("del".equals(p)){
			del(request, response);
		}else if("doma".equals(p)){
			doma(request, response);
		}else if("download".equals(p)){
			download(request, response);
		}
		
		
	}

	protected void doUpFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//使用Apache文件上传组件步骤
		DiskFileItemFactory factory=new DiskFileItemFactory();
		
		
		//得到了解析器
		ServletFileUpload servletFileUpload=new ServletFileUpload(factory);
		//判断上传是文件还是表单
		boolean result=servletFileUpload.isMultipartContent(request);
	
		System.out.print(result);
		Date date = new Date();
		String file_name=null;
		String file_desc=null;
		String autoName = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
		System.out.print(autoName);
		String username=String.valueOf(request.getSession().getAttribute("loginuser"));
		
		if(result){
			try {
				List<FileItem> fileitems=null;
				fileitems = servletFileUpload.parseRequest(request);
				System.out.println(autoName+"----------------------------------------------"+username);
				for(FileItem fileitem: fileitems){
					//相当于表单元素的input里的name属性
					if(fileitem.isFormField()){
						String fieldname=fileitem.getFieldName();	
						String value=fileitem.getString("utf-8");
						//解决代码乱码的问题
						if("file_name".equals(fieldname)){
							file_name=value;
						}else if("file_desc".equals(fieldname)){
							file_desc=value;
						}
					}
					else{
						InputStream inputStream=fileitem.getInputStream();
						if(inputStream!=null&&inputStream.available()>0){
							//得到文件名
						String filename= fileitem.getName();	
						int index=filename.lastIndexOf(".");
						String ext=filename.substring(index);
						System.out.print(filename+"   " +ext);
						autoName+=ext;
						
						String path=getServletContext().getRealPath("/uploadfile");
						System.out.println(path+"89999999999999999999999");
						File file=new File(path,autoName);
						System.out.println(file+"3456789-------------");
						//得到一个输出流，输出到服务器的磁盘
						FileOutputStream outputStream=new FileOutputStream(file);
						//一次上传1kb
					byte[] datas=new byte[1024];
					int len=0;
					while((len=inputStream.read(datas))>0){
						//读进多少字节，就写出多少字节
						outputStream.write(datas, 0, len);
						
					}
					
					outputStream.flush();
					outputStream.close();
				
					
					}
					}
				}
				
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		//调用service层的方法把相应的数据写到数据库
		
		FileServiceImpl service=new FileServiceImpl();	
		int t=service.addfile(file_name, file_desc, autoName, username);
		if(t>0){
			response.getWriter().print("<script>alert('上传成功！'); location.href='FileServlet?p=doma';</script>");
		}
		
	}

	public void doma(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileServiceImpl service=new FileServiceImpl();	
		ArrayList<Files> file=service.selectAll();
		request.setAttribute("file", file);
		request.getRequestDispatcher("/Admin/files/fileshow.jsp").forward(request, response);
		
		
		
	}

	public void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id=Integer.parseInt(request.getParameter("id"));
		FileServiceImpl service=new FileServiceImpl();
		Files f=service.selectById(id);
		String path="/uploadfile/"+f.getFile_auto_name();
		String realPath=getServletContext().getRealPath(path);
		File file=new File(realPath);
	    boolean delete=file.delete();
		int t=service.delete(id);
		if(delete&&t>0){
			response.getWriter().print("<script>alert('删除成功！');location.href='FileServlet?p=doma';</script>");
		}
		
	}
public void download(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	int id=Integer.parseInt(request.getParameter("id"));
	FileServiceImpl fs=new FileServiceImpl();
	Files f=fs.selectById(id);
	
	String path="/uploadfile/"+f.getFile_auto_name();
	String realPath=getServletContext().getRealPath(path);
	
	String auto_name=f.getFile_auto_name();
	//auto_name=URLEncoder.encode(auto_name, "utf-8");
	String ext=auto_name.substring(auto_name.lastIndexOf("."));
	
	String fileName=f.getFile_name();
	fileName+=ext;
	//处理可能会出现的乱码问题
	//fileName=URLEncoder.encode(fileName,"utf-8");
	//确定流来下载文件
	
	FileInputStream input=new FileInputStream(realPath);
	   response.reset();
       //response.setContentLength(input.available());
      // response.setContentType("charset=UTF-8");	
	   
	   String agent = (String)request.getHeader("USER-AGENT"); 
	   boolean isFireFox=(agent != null && agent.toLowerCase().indexOf("firefox")!=-1);
       if(isFireFox)
       {
    	   fileName =(new String(fileName.getBytes("UTF-8"),"ISO-8859-1"));   
       }
       else
       {
    	   fileName =  java.net.URLEncoder.encode(fileName, "UTF-8");
       }
       
       
       response.setHeader("Content-Disposition", "attachment;filename="+fileName);	
	//response.reset();
	//response.setHeader("Content-Disposition", "attachment; filename="+fileName);
	
	OutputStream out=response.getOutputStream();
	
	byte[] buf=new byte[1024];
	int i=0;
	while((i=input.read(buf))>0){
		out.write(buf,0,i);
		
	}
	input.close();
	out.flush();
	out.close();
	System.out.print("下载完成");
	
	
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}


}


