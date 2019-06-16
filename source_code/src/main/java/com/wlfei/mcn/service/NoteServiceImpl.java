package com.wlfei.mcn.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wlfei.mcn.dao.NoteDao;
import com.wlfei.mcn.dao.ShareDao;
import com.wlfei.mcn.entity.Note;
import com.wlfei.mcn.util.NoteResult;
import com.wlfei.mcn.util.NoteUtil;

@Service("noteService")
public class NoteServiceImpl implements NoteService {
	@Resource
	private NoteDao noteDao;
	@Resource
	private ShareDao shareDao;

	// 获取笔记列表
	public NoteResult<List<Map>> loadBookNotes(String bookId) {
		// 根据bookid 获取笔记列表
		List<Map> list = noteDao.findByBookId(bookId);

		NoteResult<List<Map>> result = new NoteResult<List<Map>>();
		result.setStatus(0);
		result.setMsg("加载笔记成功");
		result.setData(list);
		return result;
	}

	// 查询笔记
	public NoteResult<Note> loadNote(String noteId) {
		Note note = noteDao.findByNoteId(noteId);

		NoteResult<Note> result = new NoteResult<Note>();
		if (note == null) {
			result.setStatus(1);
			result.setMsg("未找到数据");
			return result;

		} else {
			result.setStatus(0);
			result.setMsg("加载笔记成功");
			result.setData(note);
			return result;
		}
	}

	// 更新笔记
	public NoteResult<Object> updateNote(String noteId, String title, String body) {
		Note note = new Note();
		note.setNoteId(noteId);
		note.setNoteTitle(title);
		note.setNoteBody(body);

		note.setNoteLastModifyTime(System.currentTimeMillis());

		int rows = noteDao.updateNote(note);

		NoteResult<Object> result = new NoteResult<Object>();
		if (rows == 1) {
			result.setStatus(0);
			result.setMsg("保存笔记成功");
			return result;

		} else {
			result.setStatus(1);
			result.setMsg("保存笔记失败");
			return result;
		}

	}

	// 增加笔记
	public NoteResult<Note> addNote(String userId, String bookId, String title) {
		Note note = new Note();
		note.setUserId(userId);
		note.setNotebookId(bookId);
		note.setNoteTitle(title);

		String noteId = NoteUtil.createId();
		note.setNoteId(noteId);

		note.setNoteBody("");

		long time = System.currentTimeMillis();
		note.setNoteCreateTime(time);
		note.setNoteLastModifyTime(time);
		// 1 - 正常笔记 2- 已删除
		note.setNoteStatusId("1");
		// 1 - 正常笔记 2 - favor笔记 3- 分享笔记
		note.setNoteTypeId("1");

		noteDao.save(note);

		//
		NoteResult<Note> result = new NoteResult<Note>();
		result.setStatus(0);
		result.setMsg("创建笔记成功");
		result.setData(note);
		return result;

	}

	public NoteResult deleteNote(String noteId) {
		Note note = new Note();
		note.setNoteId(noteId);
		note.setNoteStatusId("2");

		int rows = noteDao.dynamicUpdate(note);

		NoteResult result = new NoteResult();
		if (rows >= 1) {
			result.setStatus(0);
			result.setMsg("删除笔记成功");
			return result;
		} else {
			result.setStatus(1);
			result.setMsg("删除笔记失败");
			return result;

		}
	}

	public NoteResult moveNote(String noteId, String bookId) {
		Note note = new Note();
		note.setNoteId(noteId);
		note.setNotebookId(bookId);

		int rows = noteDao.dynamicUpdate(note);
		NoteResult result = new NoteResult();
		if (rows >= 1) {
			result.setStatus(0);
			result.setMsg("转移笔记成功");
			return result;
		} else {
			result.setStatus(1);
			result.setMsg("转移笔记失败");
			return result;
		}
	}

}
