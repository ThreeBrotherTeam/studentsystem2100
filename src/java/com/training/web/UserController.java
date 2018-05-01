package com.training.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.form.UserForm;
import com.training.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
	@Resource
	private UserService userService;

	// 进入注册页面
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "user/register";
	}

	// 注册用户
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(UserForm userForm) {
		userService.save(userForm);
		return "login";
	}

}
