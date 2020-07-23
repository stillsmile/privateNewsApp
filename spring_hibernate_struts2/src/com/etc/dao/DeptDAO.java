package com.etc.dao;

import java.util.List;

import com.etc.entity.Dept;

public interface DeptDAO {

	public void save(Dept dept);

	public void update(Dept dept);

	public void delete(Dept dept);

	public Dept findById( int id);

	public List<Dept> findAll();

	public int Count();
	
	public List<Dept> findPage(int page,int size);
	
}
