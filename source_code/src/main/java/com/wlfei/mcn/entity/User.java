package com.wlfei.mcn.entity;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String userName;
	private String userPassword;
	private String userToken;
	private String userNick;
	private List<Book> books;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userToken="
				+ userToken + ", userNick=" + userNick + ", books=" + books + "]";
	}

	
}
