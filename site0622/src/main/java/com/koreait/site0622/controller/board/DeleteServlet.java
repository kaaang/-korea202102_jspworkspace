package com.koreait.site0622.controller.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.site0622.model.board.dao.MybatisBoardDAO;
import com.koreait.site0622.model.domain.Board;
import com.koreait.site0622.util.message.MessageObject;

public class DeleteServlet extends HttpServlet{
	MybatisBoardDAO boardDAO;
	MessageObject messageObject;
	
	public void init() throws ServletException {
		boardDAO = new MybatisBoardDAO();
		messageObject = new MessageObject();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받아서 db에 업데이트
		request.setCharacterEncoding("utf-8");//파라미터들에 대한 인코딩
		
		
		String board_id=request.getParameter("board_id");
		
		
		//dao호출
		int result = boardDAO.delete(Integer.parseInt(board_id));
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(result>0) {
			out.print(messageObject.getMsgURL("삭제 성공", "/board/list.jsp"));
		}else {
			out.print(messageObject.getMsgBack("삭제 실패"));			
		}
		
		
	}
}
