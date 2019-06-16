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

	/**
	 * 登陆验证
	 * 
	 * @param userName
	 * @param userPassword
	 * @return
	 */
	@RequestMapping(value = "/user/login.do", method = RequestMethod.POST)
	@ResponseBody
	public NoteResult<User> userCheck(String userName, String userPassword) {
		logger.info("request user check, userName=" + userName + ", userPassword=" + userPassword);
		NoteResult<User> result = userService.checkLogin(userName, userPassword);
		return result;

	}

	/**
	 * 注册验证
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/user/regist.do", method = RequestMethod.POST)
	@ResponseBody
	public NoteResult<Object> userRegist(String userName, String userPassword, String userNick) {
		logger.info("request user regist");
		NoteResult<Object> result = userService.addUser(userName, userPassword, userNick);
		return result;
	}

	/**
	 * 修改密码
	 * 
	 * @param userName      用户名
	 * @param lastPassword  原密码
	 * @param finalPassword 新密码
	 * @return
	 */
	@RequestMapping(value = "/user/changepwd.do", method = RequestMethod.POST)
	@ResponseBody
	public NoteResult<Object> userChangePwd(String userName, String lastPassword, String finalPassword) {
		logger.info("request user userChangePwd, userName=" + userName + ",lastPassword=" + lastPassword
				+ ",finalPassword=" + finalPassword);
		NoteResult<Object> result = userService.changeUser(userName, lastPassword, finalPassword);
		return result;
	}
	@RequestMapping(value = "/user/logout.do", method = RequestMethod.POST)
	@ResponseBody
	public NoteResult<User> userLogout(String userName, String userToken) {
		logger.info("request user userLogout");
		NoteResult<User> result = userService.logout(userName, userToken);
		return result;
	}

}
