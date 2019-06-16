package com.wlfei.mcn.service;

import com.wlfei.mcn.entity.User;
import com.wlfei.mcn.util.NoteResult;

public interface UserService {
	// 验证用户名和密码的合法性
	public NoteResult<User> checkLogin(String userName, String userPassword);
	// 退出登陆
	public NoteResult<User> logout(String userName, String userToken);
	// 添加用户 保存用户名和密码
	public NoteResult<Object> addUser(String userName, String userPassword, String userNick);
	/**
	 *  修改用户名 密码
	 * @param userName 用户名
	 * @param lastPassword 上次密码
	 * @param finalPassword 要设置的密码
	 * @return
	 */
	public NoteResult<Object> changeUser(String userName, String lastPassword, String finalPassword);
}
