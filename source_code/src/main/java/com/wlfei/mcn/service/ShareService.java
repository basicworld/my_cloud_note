package com.wlfei.mcn.service;

import java.util.List;

import com.wlfei.mcn.entity.Share;
import com.wlfei.mcn.util.NoteResult;

public interface ShareService {
	// 分享 即将笔记保存到share表
	public NoteResult<Object> shareNote(String noteId);
	// 搜索
	public NoteResult<List<Share>> searchNote(String keyword);
	// 收藏
	public NoteResult<Share> loadShareNote(String shareId);
}
