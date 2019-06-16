package com.wlfei.mcn.dao;

import java.util.List;

import com.wlfei.mcn.entity.Book;

public interface BookDao {
	// 根据用户id查找笔记本 返回笔记本list
	public List<Book> findByUserId(String userId);
	// 增加笔记本
	public void save(Book book);
}
