package com.wlfei.mcn.dao;

import java.util.List;
import java.util.Map;

import com.wlfei.mcn.entity.Note;

public interface NoteDao {
	// 根据笔记本ID查找笔记 返回list
	public List<Map> findByBookId(String bookId);
	// 根据笔记ID查找笔记 返回一个笔记
	public Note findByNoteId(String noteId);
	// 跟新笔记 返回笔记id
	public int updateNote(Note note);
	// 增加笔记
	public void save(Note note);
	// 删除或移动笔记 
	public int dynamicUpdate(Note note);

}
