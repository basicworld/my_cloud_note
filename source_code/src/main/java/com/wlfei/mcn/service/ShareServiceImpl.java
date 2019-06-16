package com.wlfei.mcn.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wlfei.mcn.dao.NoteDao;
import com.wlfei.mcn.dao.ShareDao;
import com.wlfei.mcn.entity.Note;
import com.wlfei.mcn.entity.Share;
import com.wlfei.mcn.util.NoteResult;
import com.wlfei.mcn.util.NoteUtil;

@Service("shareService")
@Transactional // spring 事务？？
public class ShareServiceImpl implements ShareService {
	@Resource
	private ShareDao shareDao;
	@Resource
	private NoteDao noteDao;

	public NoteResult<Object> shareNote(String noteId) {
		Share share=new Share();
		String shareId = NoteUtil.createId();
		share.setShareId(shareId);
		share.setNoteId(noteId);
		
		// 从note库获取note
		Note note = noteDao.findByNoteId(noteId);
		share.setShareTitle(note.getNoteTitle());
		share.setShareBody(note.getNoteBody());
		// 保存分享记录
		shareDao.share(share);
		
		NoteResult<Object> result = new NoteResult<Object>();
		result.setStatus(0);
		result.setMsg("分享笔记成功");
		return result;
	}

	public NoteResult<List<Share>> searchNote(String keyword) {
		String title = "%" + keyword + "%";
		// 模糊查询
		List<Share> shares = shareDao.findLikeTitle(title);
		NoteResult<List<Share>> result = new NoteResult<List<Share>>();
		result.setStatus(0);
		result.setMsg("搜索成功");
		result.setData(shares);
		return result;
	}

	public NoteResult<Share> loadShareNote(String shareId) {
		Share share = shareDao.findById(shareId)
				;
		NoteResult<Share> result = new NoteResult<Share>();
		result.setStatus(0);
		result.setMsg("加载分享笔记成功");
		result.setData(share);
		return result;
	}

}
