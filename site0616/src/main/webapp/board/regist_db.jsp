<%@page import="site0616.medel.domain.Board"%>
<%@page import="site0616.board.medel.dao.BoardDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	BoardDAO boardDAO = new BoardDAO();//서블릿의 멤버변수로 작성
%>
<%
	
	request.setCharacterEncoding("utf-8");
	String title=request.getParameter("title"); //html에 명시한 파라미터 명
	String writer=request.getParameter("writer"); //html에 명시한 파라미터 명
	String content=request.getParameter("content"); //html에 명시한 파라미터 명
	
	//db접속
	//vo생성 및 인수로 넘기기
	Board board = new Board();
	board.setTitle(title);
	board.setWriter(writer);
	board.setContent(content);
	//실행
	int result = boardDAO.insert(board);
	out.print("<script>");
	if(result==0){
		out.print("alert('등록실패');");			
		out.print("history.back();");
	}else{
		out.print("alert('등록성공');");			
		out.print("location.href='/board/list.jsp';");
	}
	out.print("</script>");
	
%>