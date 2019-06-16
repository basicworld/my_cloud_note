package com.wlfei.mcn.dao;

import com.wlfei.mcn.entity.User;

public interface UserDao {
	// 根据用户名查找 返回用户对象
	public User findByName(String name);

	// 保存用户
	public void save(User user);

	// 修改用户密码
	public void change(User user);
}
