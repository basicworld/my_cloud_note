package com.wlfei.mcn.entity;

import java.io.Serializable;
import java.security.Timestamp;

/**
 * 笔记本
 * @author lenovo
 *
 */
public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String notebookId;
	private String userId;
	private String notebookTypeId;
	private String notebookName;
	private String notebookDesc;
	private Timestamp notebookCreateTime;
	
	private User user;

	public String getNotebookId() {
		return notebookId;
	}

	public void setNotebookId(String notebookId) {
		this.notebookId = notebookId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNotebookTypeId() {
		return notebookTypeId;
	}

	public void setNotebookTypeId(String notebookTypeId) {
		this.notebookTypeId = notebookTypeId;
	}

	public String getNotebookName() {
		return notebookName;
	}

	public void setNotebookName(String notebookName) {
		this.notebookName = notebookName;
	}

	public String getNotebookDesc() {
		return notebookDesc;
	}

	public void setNotebookDesc(String notebookDesc) {
		this.notebookDesc = notebookDesc;
	}

	public Timestamp getNotebookCreateTime() {
		return notebookCreateTime;
	}

	public void setNotebookCreateTime(Timestamp notebookCreateTime) {
		this.notebookCreateTime = notebookCreateTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Notebook [notebookId=" + notebookId + ", userId=" + userId + ", notebookTypeId=" + notebookTypeId
				+ ", notebookName=" + notebookName + ", notebookDesc=" + notebookDesc + ", notebookCreateTime="
				+ notebookCreateTime + ", user=" + user + "]";
	}
	

}
