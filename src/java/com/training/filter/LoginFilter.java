package com.training.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.model.UserModel;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		String path = request.getRequestURI();
		HttpSession session = request.getSession();
		// 登录和注册放行
		if (path.contains("/login") || path.contains("/register")) {
			filterChain.doFilter(arg0, arg1);
		} else {
			UserModel userModel = (UserModel) session.getAttribute("userInfo");
			if (null != userModel) {
				filterChain.doFilter(arg0, arg1);
			} else {
				String temp = request.getContextPath() + "/login";
				response.sendRedirect(temp);
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
