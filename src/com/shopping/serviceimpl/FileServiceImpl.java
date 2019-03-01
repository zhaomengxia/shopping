package com.shopping.serviceimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shopping.daoimpl.FileDaoImpl;
import com.shopping.entity.Files;
import com.shopping.service.FileService;

public class FileServiceImpl implements FileService{

	
	FileDaoImpl file=new FileDaoImpl();
	@Override
	public int addfile(String file_name, String file_desc, String file_auto_name, String user_name) {
		// TODO Auto-generated method stub
		Files files=new Files(file_name,file_desc,file_auto_name,user_name);
		int t=0;
		try {
			t=file.addfile(files);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public int delete(int id) {
		int t=0;
		try {
			t=file.deleteById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public ArrayList<Files> selectAll() {
		ResultSet set=null;
		ArrayList<Files> list=new ArrayList<Files>();
		try {
			set=file.select();
			while(set.next()){
				int id=set.getInt("id");
				String file_name=set.getString("file_name");
				String file_desc=set.getString("file_desc");
				String file_auto_name=set.getString("file_auto_name");
				String user_name=set.getString("user_name");
				list.add(new Files(id,file_name,file_desc,file_auto_name,user_name));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Files selectById(int id) {
		Files file1=new Files();
		ResultSet set=null;
		try {
			set=file.findFileById(id);
			if(set.next()){
				
				
				file1.setId(id);
				file1.setFile_name(set.getString("file_name"));
				file1.setFile_desc(set.getString("file_desc"));
				file1.setFile_auto_name(set.getString("file_auto_name"));
				
				file1.setUser_name(set.getString("user_name"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file1;
	}

}
