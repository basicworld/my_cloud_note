package com.wlfei.mcn.service;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.wlfei.mcn.controller.UserController;
import com.wlfei.mcn.dao.UserDao;
import com.wlfei.mcn.entity.User;
import com.wlfei.mcn.util.NoteResult;
import com.wlfei.mcn.util.NoteUtil;

@Service("userService")
public class UserServiceImpl implements UserService {
	private static final Log logger = LogFactory.getLog(UserController.class);

	@Resource
	private UserDao userDao;

	/**
	 * 注册验证
	 */
	public NoteResult<User> checkLogin(String userName, String userPassword) {
		NoteResult<User> result = new NoteResult<User>();
		User user = userDao.findByName(userName);

		if (user == null) {
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}

		String md5Password = NoteUtil.md5(userPassword);

		if (!user.getUserPassword().equals(md5Password)) {
			result.setStatus(2);
			result.setMsg("密码错误");
			return result;
		}
		String token = NoteUtil.md5(user.getUserName() + user.getUserPassword());
		user.setUserToken(token);

		result.setStatus(0);
		result.setMsg("登录成功");
		result.setData(user);
		return result;
	}

	/**
	 * 新增用户
	 */
	public NoteResult<Object> addUser(String userName, String userPassword, String userNick) {
		NoteResult<Object> result = new NoteResult<Object>();
		User hasUser = userDao.findByName(userName);
		if (hasUser != null) {
			result.setStatus(1);
			result.setMsg("用户名已存在");
			return result;

		}
		User user = new User();
		user.setUserName(userName);
		String md5Password = NoteUtil.md5(userPassword);
		user.setUserPassword(md5Password);
		user.setUserNick(userNick);

		user.setUserId(NoteUtil.createId());
		userDao.save(user);

		//
		result.setStatus(0);
		result.setMsg("注册成功");
		return result;
	}

	/**
	 * 修改用户密码
	 */
	public NoteResult<Object> changeUser(String userName, String lastPassword, String finalPassword) {
		NoteResult<Object> result = new NoteResult<Object>();
		User user = userDao.findByName(userName);
		String userPassword = user.getUserPassword();
		// 检查用户传入的密码是否正确
		if (!userPassword.equals(NoteUtil.md5(lastPassword))) {
			logger.debug("原密码不正确, md5 should be [" + userPassword + "], not [" + NoteUtil.md5(lastPassword) + "]");
			// 原密码不正确
			result.setStatus(1);
			result.setMsg("原密码不正确");
			return result;

		} else if (userPassword == NoteUtil.md5(finalPassword)) {
			result.setStatus(2);
			result.setMsg("新旧密码一致，不能修改");
			return result;
			// 新旧密码不能相同

		} else {
			// 修改密码
			user.setUserPassword(NoteUtil.md5(finalPassword));
			userDao.change(user);

			result.setStatus(0);
			result.setMsg("修改密码成功");
			return result;
		}

	}

	/**
	 * 退出登录 登出
	 */
	public NoteResult<User> logout(String userName, String userToken) {
		User user = userDao.findByName(userName);
		NoteResult<User> result = new NoteResult<User>();
		result.setStatus(0);
		result.setMsg("登出成功");
		result.setData(user);
		return result;
	}

}
