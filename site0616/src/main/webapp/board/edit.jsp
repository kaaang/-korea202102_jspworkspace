<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%
	

	
	//오라클에 넣기
	Class.forName("oracle.jdbc.driver.OracleDriver");
	out.print("드라이버 로드 성공<br>");
	
	//오라클 접속
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "webmaster", "1234");
	PreparedStatement pstmt=null;
	if(con==null){
		out.print("접속 실패 <br>");
	}else{
		out.print("접속 성공 <br>");
		
		
		//클라이언트인 detail.jsp로부터 4개의 파라미터 받기
		request.setCharacterEncoding("utf-8");
		String title=request.getParameter("title");
		String writer=request.getParameter("writer");
		String content=request.getParameter("content");
		String board_id=request.getParameter("board_id");

		
		String sql="update board set title=?,writer=?,content=? where board_id=?";
		
		
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,title);
		pstmt.setString(2,writer);
		pstmt.setString(3,content);
		pstmt.setInt(4,Integer.parseInt(board_id) );
		
		int result = pstmt.executeUpdate();
		
		out.print("<script>");
		if(result==0){
			out.print("alert('수정실패');");
			out.print("history.back();");
		}else{
			out.print("alert('수정성공');");
			out.print("location.href='/board/detail.jsp?board_id="+board_id+"';");
		}
		out.print("</script>");
		
		pstmt.close();
		con.close();
	}



	
%>