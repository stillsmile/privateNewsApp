package com.etc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.etc.dao.DeptDAO;
import com.etc.entity.Dept;

public class ListAction {

	private DeptDAO deptDao;// dao通过spring容器注入进来
	private List<Dept> depts = new ArrayList();
	
	
	private String str;

	public String execute() {
		//depts = deptDao.findAll();
		Dept dept = new Dept();
		dept.setId(1000);
		depts.add(dept);
		str = depts.toString();
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
        PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print("hello " + str);
	        writer.flush();
	        writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

	public DeptDAO getDeptDao() {
		return deptDao;
	}

	public void setDeptDao(DeptDAO deptDao) {
		this.deptDao = deptDao;
	}

	public List<Dept> getDepts() {
		return depts;
	}

	public void setDepts(List<Dept> depts) {
		this.depts = depts;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
}
