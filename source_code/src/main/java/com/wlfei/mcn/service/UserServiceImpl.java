package com.wlfei.mcn.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wlfei.mcn.entity.User;
import com.wlfei.mcn.util.NoteResult;
import com.wlfei.mcn.util.NoteUtil;

@Service
public class UserServiceImpl implements  UserService{

//	@Resource
//	private UserDao userDao;
	
	public NoteResult<User> checkLogin(String userName, String userPassword) {
		NoteResult<User> result = new NoteResult<User>();
//		User user = userDao.findByName(name);
		User user = new User();
		
		// 临时用
		user.setUserName(userName);
		user.setUserToken(NoteUtil.md5(userPassword));
		
//		if(user==null) {
//			result.setStatus(1);
//			result.setMsg("用户名不存在");
//			return result;
//		}
//		
//		String md5Password = NoteUtil.md5(userPassword);
//		
//		if(!user.getUserPassword().equals(md5Password)) {
//			result.setStatus(2);
//			result.setMsg("密码错误");
//			return result;
//		}
		
		result.setStatus(0);
		result.setMsg("登录成功");
		result.setData(user);
		return result;
	}

}
