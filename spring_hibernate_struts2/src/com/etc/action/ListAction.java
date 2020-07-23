package com.etc.action;

import java.util.List;

import com.etc.dao.DeptDAO;
import com.etc.entity.Dept;

public class ListAction {

	private DeptDAO deptDao;// dao通过spring容器注入进来
	private List<Dept> depts;

	public String execute() {
		//depts = deptDao.findAll();
		Dept dept = new Dept();
		dept.setId(1000);
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

}
