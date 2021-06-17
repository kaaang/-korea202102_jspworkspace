<%@page import="site0616.board.medel.dao.BoardDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%! BoardDAO boardDAO = new BoardDAO(); %>
<%
	

	
	
		request.setCharacterEncoding("utf-8");
		String board_id=request.getParameter("board_id");

		int result = boardDAO.del(Integer.parseInt(board_id));
		
		out.print("<script>");
		if(result==0){
			out.print("alert('삭제실패');");
			out.print("history.back();");
		}else{
			out.print("alert('삭제성공');");
			out.print("location.href='/board/list.jsp';");
		}
		out.print("</script>");
		
	

	


	
%>