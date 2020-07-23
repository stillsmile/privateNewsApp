package com.etc.action;

import com.etc.dao.DeptDAO;
import com.etc.entity.Dept;



public class AddAction {
	// 根据输入算出输出
	private Dept dept; // 自动封装

	// DAO
	private DeptDAO deptDao;// dao通过spring容器注入进来

	
	public String execute() {
		deptDao.save(dept);
		return "success";
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public DeptDAO getDeptDao() {
		return deptDao;
	}

	public void setDeptDao(DeptDAO deptDao) {
		this.deptDao = deptDao;
	}

}
