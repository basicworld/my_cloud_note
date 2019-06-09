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

	@RequestMapping(value = { "/login", "/" })
	public String login(Model model) {
		logger.info("request login");
		model.addAttribute("user", new User());
		return "Login";
	}

	@RequestMapping(value = "/regist")
	public String register(Model model) {
		logger.info("request regist");
		model.addAttribute("user", new User());
		return "Regist";
	}
}
