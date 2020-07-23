package com.etc.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etc.dao.DeptDAO;
import com.etc.entity.Dept;

public class TestHibernate {

	@Test
	public void test1() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"ssh.xml");
		DeptDAO dao = (DeptDAO) ac.getBean("deptDao");
		Dept dept = new Dept();
		dept.setDname("yanfabu1405");
		dept.setLoc("wx");
		dao.save(dept);

	}

	@Test
	public void test2() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring_hibernate.xml");
		DeptDAO dao = (DeptDAO) ac.getBean("deptDAO");
		Dept d = dao.findById(4);
		dao.delete(d);

	}

	@Test
	public void test3() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring_hibernate.xml");
		DeptDAO dao = (DeptDAO) ac.getBean("deptDAO");
		Dept d = dao.findById(2);
		d.setDname("shanghaiceshibu2");
		dao.update(d);

	}

	@Test
	public void test4() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring_hibernate.xml");
		DeptDAO dao = (DeptDAO) ac.getBean("deptDAO");
		System.out.println("一共有" + dao.Count() + "个部门");
		System.out.println("---------------------");
		List<Dept> depts = dao.findAll();
		for (Dept d : depts) {
			System.out.println(d.getDname() + " " + d.getLoc());
		}
	}

	@Test
	public void test5() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring_hibernate.xml");
		DeptDAO dao = (DeptDAO) ac.getBean("deptDAO");
		Dept d = dao.findById(1);
		System.out.println(d.getDname() + " " + d.getLoc());

	}

	@Test
	public void test6() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"spring_hibernate.xml");
		DeptDAO dao = (DeptDAO) ac.getBean("deptDAO");
		List<Dept> depts = dao.findPage(2, 2);
		for (Dept d : depts) {
			System.out.println(d.getDname() + " " + d.getLoc());
		}

	}

}
