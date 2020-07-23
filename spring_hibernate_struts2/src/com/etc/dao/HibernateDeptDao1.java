package com.etc.dao;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.etc.entity.Dept;

public class HibernateDeptDao1 extends HibernateDaoSupport implements DeptDAO {

	@SuppressWarnings("unchecked")
	public int Count() {
		String hql = "select count(*) from Dept";
		List<Long> list = this.getHibernateTemplate().find(hql);
		return list.get(0).intValue();
	}

	public void delete(Dept dept) {
		this.getHibernateTemplate().delete(dept);

	}

	@SuppressWarnings("unchecked")
	public List<Dept> findAll() {
		String hql = "from Dept";
		List<Dept> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	public Dept findById(int id) {
		String hql = "from Dept where id=?";
		List<Dept> depts = this.getHibernateTemplate().find(hql,
				new Object[] { id });
		if (!depts.isEmpty()) {
			Dept d = depts.get(0);
			return d;
		}
		return null;
	}

	public void save(Dept dept) {
		this.getHibernateTemplate().save(dept);

	}

	public void update(Dept dept) {
		this.getHibernateTemplate().update(dept);

	}

	public List<Dept> findPage(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
