package com.wlfei.mcn.entity;

import java.io.Serializable;

public class Share implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String shareId;
	private String shareTitle;
	private String shareBody;
	private String noteId;
	public String getShareId() {
		return shareId;
	}
	public void setShareId(String shareId) {
		this.shareId = shareId;
	}
	public String getShareTitle() {
		return shareTitle;
	}
	public void setShareTitle(String shareTitle) {
		this.shareTitle = shareTitle;
	}
	public String getShareBody() {
		return shareBody;
	}
	public void setShareBody(String shareBody) {
		this.shareBody = shareBody;
	}
	public String getNoteId() {
		return noteId;
	}
	public void setNoteId(String noteId) {
		this.noteId = noteId;
	}
	@Override
	public String toString() {
		return "Share [shareId=" + shareId + ", shareTitle=" + shareTitle + ", shareBody=" + shareBody + ", noteId="
				+ noteId + "]";
	}
	

}
