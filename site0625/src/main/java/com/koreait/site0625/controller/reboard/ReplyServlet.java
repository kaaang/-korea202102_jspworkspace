package com.koreait.site0625.controller.reboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReplyServlet extends HttpServlet{

	
	public void init() throws ServletException {

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
		String writer=request.getParameter("writer");
		String content=request.getParameter("content");
		String team=request.getParameter("team");
		String step=request.getParameter("step");
		String depth=request.getParameter("depth");
	}
	
}
