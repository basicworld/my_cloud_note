package com.wlfei.mcn.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wlfei.mcn.dao.BookDao;
import com.wlfei.mcn.entity.Book;
import com.wlfei.mcn.util.NoteResult;
import com.wlfei.mcn.util.NoteUtil;

@Service("bookService")
public class BookServiceImpl implements BookService {
	@Resource
	BookDao bookDao;

	public NoteResult<List<Book>> loadUserBook(String userId) {
		NoteResult<List<Book>> result = new NoteResult<List<Book>>();
		
		List<Book> books = bookDao.findByUserId(userId);
		
		result.setStatus(0);
		result.setMsg("查询笔记本成功");
		result.setData(books);
		return result;
	}

	public NoteResult<Book> addBook(String userId, String bookTitle) {
		Book book = new Book();
		// 增加笔记本id
		String bookId = NoteUtil.createId();
		book.setNotebookId(bookId);
		// 增加用户id
		book.setUserId(userId);
		// 增加笔记本名称
		book.setNotebookName(bookTitle);
		// 增加笔记本类型
		book.setNotebookTypeId("1");
		// 增加笔记本创建时间
		Timestamp time = new Timestamp(System.currentTimeMillis());
		book.setNotebookCreateTime(time);
		// 保存笔记本
		bookDao.save(book);
		// 返回结果
		NoteResult<Book> result = new NoteResult<Book>();
		result.setStatus(0);
		result.setMsg("创建笔记本成功");
		result.setData(book);
		return result;
		
		
	}
	
	
}
