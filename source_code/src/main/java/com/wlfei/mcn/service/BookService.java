package com.wlfei.mcn.service;

import java.util.List;

import com.wlfei.mcn.entity.Book;
import com.wlfei.mcn.util.NoteResult;

public interface BookService {
	// 根据用户id查找笔记本list
	public NoteResult<List<Book>> loadUserBook(String userId);
	
	// 添加笔记本
	public NoteResult<Book> addBook(String userId, String bookTitle);
}
