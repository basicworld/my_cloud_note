package com.wlfei.mcn.dao;

import java.util.List;

import com.wlfei.mcn.entity.Share;

public interface ShareDao {
	// 分享 将分享的内容插入到share表
	public void share(Share share);
	// 搜索 根据标题搜索分享的note
	public List<Share> findLikeTitle(String title);
	// 查询 跟据shareId查询
	public Share findById(String shareId);
}
