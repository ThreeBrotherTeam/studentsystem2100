package com.training.converter;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import com.training.form.UserForm;
import com.training.model.UserModel;

public class UserModelConvert implements Converter<UserForm, UserModel> {

	@Override
	public UserModel convert(UserForm form) {
		UserModel userModel = new UserModel();
		userModel.setUserName(form.getUserName());
		userModel.setPassword(form.getPassword());
		userModel.setAvailable(true);
		userModel.setCreateDate(new Date());
		userModel.setModifyDate(new Date());
		return userModel;
	}

}
