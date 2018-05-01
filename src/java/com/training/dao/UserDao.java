package com.training.dao;

import com.training.model.UserModel;

public interface UserDao {

	void save(UserModel userModel);

	void delete(UserModel userModel);

	UserModel findById(Integer id);

	void modifyUser(UserModel model);

	UserModel findUser(UserModel userModel);

}
