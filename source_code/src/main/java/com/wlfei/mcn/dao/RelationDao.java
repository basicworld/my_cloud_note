package com.wlfei.mcn.dao;

import java.util.List;

import com.wlfei.mcn.entity.Book;
import com.wlfei.mcn.entity.User;

public interface RelationDao {
	// 关联多个对象
	public User findUserAndBooks(String userId);

	// 关联单个对象
	public List<Book> findBookAndUser();
}
