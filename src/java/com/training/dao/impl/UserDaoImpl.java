package com.training.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.training.dao.UserDao;
import com.training.model.UserModel;

public class UserDaoImpl implements UserDao {
	private HibernateTemplate hibernateTemplate;
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	// 用户注册
	@Override
	public void save(UserModel userModel) {
		hibernateTemplate.save(userModel);
	}

	// 删除用户信息
	@Override
	public void delete(UserModel userModel) {
		hibernateTemplate.delete(userModel);
	}

	// 查询用户信息
	@Override
	public UserModel findById(Integer id) {
		return hibernateTemplate.load(UserModel.class, id);
	}

	// 修改用户信息
	@Override
	public void modifyUser(UserModel model) {
		hibernateTemplate.saveOrUpdate(model);
	}

	// 查询用户信息
	@Override
	public UserModel findUser(UserModel userModel) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(" From UserModel Where userName=? and password=? and available=true");
		query.setParameter(0, userModel.getUserName());
		query.setParameter(1, userModel.getPassword());
		UserModel model = (UserModel) query.uniqueResult();
		return model;
	}

}
