package com.wlfei.mcn.service;

import com.wlfei.mcn.entity.User;
import com.wlfei.mcn.util.NoteResult;

public interface UserService {
	public NoteResult<User> checkLogin(String userName, String userPassword);
}
