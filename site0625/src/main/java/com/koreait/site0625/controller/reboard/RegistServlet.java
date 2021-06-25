package com.koreait.site0625.controller.reboard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.site0625.model.domain.ReBoard;
import com.koreait.site0625.model.reboard.dao.MybatisReBoardDAO;
import com.koreait.site0625.model.reboard.dao.ReBoardDAO;
import com.koreait.site0625.util.message.MessageObject;

public class RegistServlet extends HttpServlet{

	ReBoardDAO reBoardDAO;
	MessageObject obj;
	public void init() throws ServletException {
		reBoardDAO = new MybatisReBoardDAO();
		obj = new MessageObject();
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String title=request.getParameter("title");
		String writer=request.getParameter("writer");
		String content=request.getParameter("content");
		
		ReBoard reboard = new ReBoard();
		reboard.setTitle(title);
		reboard.setWriter(writer);
		reboard.setContent(content);
		
		
		//쿼리 실행
		int result = reBoardDAO.insert(reboard);
		
		//출력
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(result==0) {
			out.print(obj.getMsgBack("등록 실패"));
		}else {
			out.print(obj.getMsgURL("등록 성공","/reboard/list.jsp"));
		}
	}
	
	
	
}
