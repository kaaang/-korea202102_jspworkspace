package com.koreait.model2app.model.board.dao;

import java.util.List;

import com.koreait.model2app.model.domain.Board;

//모델 파트의 모든 하위 DAO들이 반드시 정의할 메서드 정의
public interface BoardDAO {
	//목록 가져오기
	public List selectAll();	
	//한건넣기
	public int insert(Board board);
	//한건 가져오기
	public Board select(int board_id);
	//수정하기
	public int update(Board board);
	//삭제하기
	public int delete(int board_id);
}
