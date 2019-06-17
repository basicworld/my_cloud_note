package com.wlfei.mcn.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wlfei.mcn.entity.Share;
import com.wlfei.mcn.service.NoteService;
import com.wlfei.mcn.service.ShareService;
import com.wlfei.mcn.util.NoteResult;

@Controller
public class ShareController {
	private static final Log logger = LogFactory.getLog(NoteController.class);
	@Resource
	private NoteService noteService;
	@Resource
	private ShareService shareService;

	// 分享一条笔记
	@RequestMapping(value = "/share/insert.do", method = RequestMethod.POST)
	@ResponseBody
	public NoteResult<Object> insertShareNote(String noteId) {
		logger.info("request addShareNote, noteId=" + noteId);
		NoteResult<Object> result = shareService.shareNote(noteId);
		return result;
	}

	// 查询分享的笔记
	@RequestMapping(value = "/share/search.do", method = RequestMethod.POST)
	@ResponseBody
	public NoteResult<List<Share>> listShareNotes(String keyword) {
		logger.info("request searchShareNote, keyword=" + keyword);
		NoteResult<List<Share>> result = shareService.searchNote(keyword);
		return result;
	}

	// 加载一条share 类型笔记
	@RequestMapping(value = "/share/get.do", method = RequestMethod.POST)
	@ResponseBody
	public NoteResult<Share> getShareNote(String shareId) {
		logger.info("request loadShareNote, shareId=" + shareId);
		NoteResult<Share> result = shareService.loadShareNote(shareId);
		return result;
	}
}
