package com.training.service.impl;

import java.util.Date;

import com.training.converter.UserModelConvert;
import com.training.dao.UserDao;
import com.training.form.UserForm;
import com.training.model.UserModel;
import com.training.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	private UserModelConvert userModelConvert;

	// 注册用户
	@Override
	public void save(UserForm userForm) {
		UserModel userModel = userModelConvert.convert(userForm);
		userDao.save(userModel);
	}

	// 删除用户信息
	@Override
	public void delete(Integer id) {
		UserModel userModel = userDao.findById(id);
		userModel.setAvailable(false);
		userModel.setModifyDate(new Date());
		userDao.modifyUser(userModel);
	}

	// 根据ID查询用户
	@Override
	public UserModel findById(Integer id) {
		UserModel userModel = userDao.findById(id);
		return userModel;
	}

	// 修改用户信息
	@Override
	public void modify(UserForm userForm) {
		UserModel userModel = userDao.findById(userForm.getId());
		userModel.setPassword(userForm.getPassword());
		userModel.setModifyDate(new Date());
		userDao.modifyUser(userModel);
	}

	// 查询用户
	public UserModel find(UserForm userForm) {
		UserModel userModel = userModelConvert.convert(userForm);
		UserModel model = userDao.findUser(userModel);
		return model;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserModelConvert getUserModelConvert() {
		return userModelConvert;
	}

	public void setUserModelConvert(UserModelConvert userModelConvert) {
		this.userModelConvert = userModelConvert;
	}

}
