package com.wlfei.mcn.service;

import java.util.List;
import java.util.Map;

import com.wlfei.mcn.entity.Note;
import com.wlfei.mcn.util.NoteResult;

public interface NoteService {
	// 根据bookId 查询里面的笔记
	public NoteResult<List<Map>> loadBookNotes(String bookId);
	// 根据noteId 查询笔记
	public NoteResult<Note> loadNote(String noteId);
	// 更新笔记
	public NoteResult<Object> updateNote(String noteId, String title, String body);
	// 增加笔记
	public NoteResult<Note> addNote(String userId, String bookId, String title);
	// 删除笔记
	public NoteResult deleteNote(String noteId);
	// 转移笔记
	public NoteResult moveNote(String noteId, String bookId);
}
