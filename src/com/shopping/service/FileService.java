package com.shopping.service;

import java.util.ArrayList;

import com.shopping.entity.Files;

public interface FileService {

	public int addfile(String file_name,String file_desc,String file_auto_name,String user_name);
	public int delete(int id);
	public ArrayList<Files> selectAll();
	public Files selectById(int id);
}
