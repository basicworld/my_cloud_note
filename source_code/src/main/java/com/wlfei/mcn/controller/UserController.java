package com.wlfei.mcn.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wlfei.mcn.entity.User;
import com.wlfei.mcn.service.UserService;
import com.wlfei.mcn.util.NoteResult;

@Controller
public class UserController {
	private static final Log logger = LogFactory.getLog(UserController.class);
	
	@Resource
	private UserService userService;

	@RequestMapping(value = "/user/login.do", method = RequestMethod.POST)
	@ResponseBody
	public NoteResult<User> userCheck(String userName, String userPassword) {
		logger.info("request user check, userName="+userName + ", userPassword="+userPassword);
		NoteResult<User> result = userService.checkLogin(userName, userPassword);
		return result;

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
