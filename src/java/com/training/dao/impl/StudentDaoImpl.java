package com.training.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.training.dao.StudentDao;
import com.training.model.StudentModel;
import com.training.page.Page;

public class StudentDaoImpl implements StudentDao {
	private HibernateTemplate hibernateTemplate;
	private SessionFactory sessionFactory;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 添加学生信息
	@Override
	public void saveStudent(StudentModel model) {
		hibernateTemplate.save(model);
	}

	// 修改学生信息
	@Override
	public void modifyStu(StudentModel model) {
		hibernateTemplate.saveOrUpdate(model);
	}

	// 删除学生信息
	@Override
	public void delete(StudentModel model) {
		hibernateTemplate.delete(model);
	}

	// 根据id查询学生信息
	@Override
	public StudentModel findById(Integer id) {
		return hibernateTemplate.load(StudentModel.class, id);
	}

	// 分页查询学生信息
	@Override
	public List<StudentModel> getStus(Page page) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from StudentModel where available=true order by modifyDate desc");
		query.setFirstResult((page.getCurrentPage() - 1) * page.getPageSize());
		query.setMaxResults(page.getPageSize());
		return query.list();
	}

	// 查看学生表中有多少条数据
	@Override
	public Integer find() {
		Session session = sessionFactory.getCurrentSession();
		Object obj = session.createQuery("Select count(*) from StudentModel where available=true").uniqueResult();
		Integer totalCount = new Integer(obj.toString());
		return totalCount;
	}

}
