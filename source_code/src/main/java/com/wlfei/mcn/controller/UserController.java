package com.wlfei.mcn.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wlfei.mcn.entity.User;

@Controller
public class UserController {
	private static final Log logger = LogFactory.getLog(UserController.class);

	@RequestMapping(value = "/user/login.do", method = RequestMethod.POST)
	public String userCheck(@ModelAttribute User user, Model model) {
		logger.info("request user check");
		logger.info(user);
		// 用户名或密码为空，则重新登陆
		if (user.getUserName() == null || user.getUserName().length() == 0 || user.getUserPassword() == null
				|| user.getUserPassword().length() == 0) {
			logger.info("userName or password is null");
			return "redirect:/login";
		}
		// 用户名和密码非空，跳转到编辑页面
		return "Edit";
	}
	@RequestMapping(value = "/user/regist.do", method = RequestMethod.POST)
	public String userRegist(@ModelAttribute User user, Model model) {
		logger.info("request user regist");
		logger.info(user);
		// todo 用户信息校验
		
		// 用户名和密码非空，跳转到编辑页面
		return "redirect:/login";
	}

}
