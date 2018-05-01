package com.training.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.form.UserForm;
import com.training.model.UserModel;
import com.training.service.UserService;

@Controller
@RequestMapping("/")
public class LoginController {
	@Resource
	private UserService userService;

	// 进入登录页面
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	// 用户登录
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserForm userForm, HttpSession session) {
		UserModel userModel = userService.find(userForm);
		if (null == userModel) {
			return "redirect:/login";
		}
		session.setAttribute("userInfo", userModel);
		return "redirect:/stu/findAll";
	}
}
