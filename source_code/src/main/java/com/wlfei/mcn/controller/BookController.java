package com.wlfei.mcn.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
	private static final Log logger = LogFactory.getLog(BookController.class);
	@RequestMapping(value="edit")
	public String edit() {
		logger.info("request edit");
		return "Edit";
	}
}
