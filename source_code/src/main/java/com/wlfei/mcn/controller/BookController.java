package com.wlfei.mcn.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wlfei.mcn.entity.Book;
import com.wlfei.mcn.service.BookService;
import com.wlfei.mcn.util.NoteResult;

@Controller
public class BookController {
	private static final Log logger = LogFactory.getLog(BookController.class);
	
	@Resource
	private BookService bookService; 
	
	// 添加笔记本
	@RequestMapping(value = "/book/insert.do", method = RequestMethod.POST)
	@ResponseBody
	public NoteResult<Book> insertBook(String userId, String title) {
		logger.info("request addBook, userId=" + userId + ", book title=" + title);
		NoteResult<Book> result = bookService.addBook(userId, title);;
		return result;

	}
	// 加载所有笔记本 list形式
	@RequestMapping(value = "/book/listbooks.do", method = RequestMethod.POST)
	@ResponseBody
	public NoteResult<List<Book>> listUserBooks(String userId) {
		logger.info("request loadBooks, userId=" + userId);
		NoteResult<List<Book>> result = bookService.loadUserBook(userId);
		return result;
		
	}
	
	// todo 删除笔记本
}
