<%@page import="site0616.medel.domain.Board"%>
<%@page import="site0616.board.medel.dao.BoardDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%! BoardDAO boardDAO = new BoardDAO(); %>
<%
	
		//클라이언트인 detail.jsp로부터 4개의 파라미터 받기
		request.setCharacterEncoding("utf-8");
		String title=request.getParameter("title");
		String writer=request.getParameter("writer");
		String content=request.getParameter("content");
		String board_id=request.getParameter("board_id");
		
		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		board.setBoard_id(Integer.parseInt(board_id));
		
		int result = boardDAO.edit(board);
		
		out.print("<script>");
		if(result==0){
			out.print("alert('수정실패');");
			out.print("history.back();");
		}else{
			out.print("alert('수정성공');");
			out.print("location.href='/board/detail.jsp?board_id="+board_id+"';");
		}
		out.print("</script>");
		
		
	



	
%>