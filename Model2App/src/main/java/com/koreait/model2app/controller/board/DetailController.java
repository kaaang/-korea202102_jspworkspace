package com.koreait.model2app.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.model.board.dao.BoardDAO;
import com.koreait.model2app.model.board.dao.JdbcBoardDAO;
import com.koreait.model2app.model.board.dao.MybatisBoardDAO;
import com.koreait.model2app.model.domain.Board;

public class DetailController implements Controller{
	BoardDAO boardDAO;
	public DetailController() {
		boardDAO = new MybatisBoardDAO();
//		boardDAO = new JdbcBoardDAO();
	}
	
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		String board_id = request.getParameter("board_id");
		Board board = boardDAO.select(Integer.parseInt(board_id));
		
		//결과 저장
		request.setAttribute("board",board);
	}

	public String getViewName() {
		return "/result/board/detail";
	}

	@Override
	public boolean isForward() {
		return true;
	}

}
