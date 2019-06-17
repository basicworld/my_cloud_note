package com.wlfei.mcn.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wlfei.mcn.entity.User;

/**
 * 处理get请求
 * @author lenovo
 *
 */
@Controller
public class MainController {
	private static final Log logger = LogFactory.getLog(MainController.class);
	@RequestMapping(value="edit")
	public String edit() {
		logger.info("request edit");
		return "Edit";
	}

	@RequestMapping(value = { "/login", "/" })
	public String login(Model model) {
		logger.info("request login");
		return "Login";
	}

	@RequestMapping(value = "/regist")
	public String register(Model model) {
		logger.info("request regist");
		return "Regist";
	}
	@RequestMapping(value = "/changepwd")
	public String changePassword(Model model) {
		logger.info("request changePassword");
		return "ChangePwd";
	}
}
