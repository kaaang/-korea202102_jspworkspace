package com.koreait.model2app.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.model.board.dao.BoardDAO;
import com.koreait.model2app.model.board.dao.JdbcBoardDAO;
import com.koreait.model2app.model.board.dao.MybatisBoardDAO;
import com.koreait.model2app.model.domain.Board;

public class RegistController implements Controller{
	BoardDAO boardDAO;
	
	public RegistController() {
		boardDAO = new MybatisBoardDAO();
//		boardDAO = new JdbcBoardDAO();
	}

	public void excute(HttpServletRequest request, HttpServletResponse response) {
		//파라미터를 넘겨받아 vo에 채워넣어야한다.
		String title=request.getParameter("title");
		String writer=request.getParameter("writer");
		String content=request.getParameter("content");
		
		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		boardDAO.insert(board);
		
		//4단계 글쓴후 저장할것이 없다
	}

	public String getViewName() {
		return "/result/board/regist";
	}
	
	public boolean isForward() {
		return false;//리다리엑트 x 
	}

}
