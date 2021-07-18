package com.koreait.springdb.model.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.koreait.springdb.model.domain.Board;
import com.koreait.springdb.model.repository.board.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	@Qualifier("mybatisBoardDAO")
	private BoardDAO boardDAO;//결합도른 낮추기 위함

	public List SelectAll() {
		return boardDAO.SelectAll();
	}

	public void regist(Board board) {
		
	}

	public Board select(int board_id) {
		return boardDAO.select(board_id);
	}

	public void update(Board board) {
		
	}

	public void delete(int board_id) {
		
	}

}
