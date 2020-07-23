package com.etc.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.etc.entity.Dept;

public class HibernateDeptDao implements DeptDAO {

	// spring提供了一个工具类 HibernateTemplate
	private HibernateTemplate template;

	public void setSessionFactory(SessionFactory sessionFactory) {
		template = new HibernateTemplate(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	public int Count() {
		String hql = "select count(*) from Dept";
		List<Long> list = template.find(hql);
		return list.get(0).intValue();
	}

	public void delete(Dept dept) {
		template.delete(dept);

	}

	@SuppressWarnings("unchecked")
	public List<Dept> findAll() {
		String hql = "from Dept";
		List<Dept> list = template.find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	public Dept findById(final int id) {
		// String hql = "from Dept where id=?";
		// List<Dept> depts = template.find(hql, new Object[] { id });
		// if (!depts.isEmpty()) {
		// Dept d = depts.get(0);
		// return d;
		// }
		// return null;

		// 通过spring这个工具类template.execute()的一个回调函数实现使用以前的session
		Dept dept = (Dept) template.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Dept d = (Dept) session.get(Dept.class, id);
				return d;
			}
		});
		return dept;
	}

	public void save(Dept dept) {
		template.save(dept);

	}

	public void update(Dept dept) {
		template.update(dept);

	}

	/**
	 * 分页处理
	 */
	@SuppressWarnings("unchecked")
	public List<Dept> findPage(final int page, final int size) {
		List<Dept> depts = (List<Dept>) template.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from Dept";
				Query query = session.createQuery(hql);
				query.setFirstResult((page - 1) * size);
				query.setMaxResults(size);
				return query.list();
			}
		});
		return depts;
	}

}
