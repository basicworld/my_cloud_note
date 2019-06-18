package com.wlfei.mcn.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wlfei.mcn.entity.Note;
import com.wlfei.mcn.entity.Share;
import com.wlfei.mcn.service.NoteService;
import com.wlfei.mcn.service.ShareService;
import com.wlfei.mcn.util.NoteResult;

public class NoteController {
	private static final Log logger = LogFactory.getLog(NoteController.class);
	@Resource
	private NoteService noteService;
	@Resource
	private ShareService shareService;

	// 添加笔记
	@RequestMapping(value = "/note/insert.do", method = RequestMethod.POST)
	@ResponseBody
	public NoteResult<Note> addNote(String userId, String bookId, String title) {
		logger.info("request addNote, userId=" + userId + ", bookId=" + bookId+ ", note title=" + title);
		NoteResult<Note> result = noteService.addNote(userId, bookId, title);
		return result;
	}
	
	
	// 删除笔记
	@RequestMapping(value = "/note/delete.do", method = RequestMethod.POST)
	@ResponseBody
	public NoteResult deleteNote(String noteId) {
		logger.info("request deleteNote, noteId=" + noteId);
		NoteResult result = noteService.deleteNote(noteId);
		return result;
	}
	// 移动笔记
	@RequestMapping(value = "/note/move.do", method = RequestMethod.POST)
	@ResponseBody
	public NoteResult moveNote(String noteId, String bookId) {
		logger.info("request moveNote, noteId=" + noteId + ",bookId="+bookId);
		NoteResult result = noteService.moveNote(noteId, bookId);
		return result;
	}
	// 加载一条笔记
	@RequestMapping(value = "/note/get.do", method = RequestMethod.POST)
	@ResponseBody
	public NoteResult loadNote(String noteId) {
		logger.info("request loadNote, noteId=" + noteId);
		NoteResult result = noteService.loadNote(noteId);
		return result;
	}
	// 更新一条笔记
	@RequestMapping(value = "/note/update.do", method = RequestMethod.POST)
	@ResponseBody
	public NoteResult<Object> updateNote(String noteId, String title, String body) {
		logger.info("request updateNote, noteId=" + noteId +",title=" + title +",body=" + body);
		NoteResult<Object> result = noteService.updateNote(noteId, title, body);
		return result;
	}
	
	// 加载笔记本的所有笔记
	@RequestMapping(value = "/note/listnotes.do", method = RequestMethod.POST)
	@ResponseBody
	public NoteResult<List<Map>> listNotesForBook(String bookId) {
		logger.info("request loadNotes, bookId=" + bookId);
		NoteResult<List<Map>> result = noteService.loadBookNotes(bookId);
		return result;
	}
}
