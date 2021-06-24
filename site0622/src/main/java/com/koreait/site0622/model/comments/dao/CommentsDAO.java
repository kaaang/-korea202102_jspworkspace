package com.koreait.site0622.model.comments.dao;

import java.util.List;

import com.koreait.site0622.model.domain.Comments;
import com.koreait.site0622.model.domain.News;

public interface CommentsDAO {
	public int insert(Comments comments);
	public List selectAll();
	public Comments select(int comments_id);
	public int update(Comments comments);
	public int delete(int comments_id);
	
	//해당 뉴스에 딸려있는 댓글 목록
	public List selectByNewsId(int news_id);
}
