package com.training.service;

import com.training.form.UserForm;
import com.training.model.UserModel;

public interface UserService {

	void save(UserForm userForm);

	void delete(Integer id);

	UserModel findById(Integer id);

	void modify(UserForm userForm);

	UserModel find(UserForm userForm);

}
