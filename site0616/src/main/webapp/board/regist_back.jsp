<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//이 영역은 스크립틀릿 영역이므로, 서블릿의 service()메서드에 코드를 작성하는 것과 같다.
	//내장 객체의 형태로 요청 객체와 응답 객체가 전달된다.
	//내장 객체란? 개발자가 생성한것이 아닌, 이미 시스템 즉 톰켓과 같은 웹 컨테이너가 그 명칭을 이미 정해놓은 내장된 javaEE의 객체들을 의미한다.
	//HttpServletRequest -> request 내장객체		
	//HttpServletResponse -> response 내장객체
	request.setCharacterEncoding("utf-8");
	String title=request.getParameter("title"); //html에 명시한 파라미터 명
	String writer=request.getParameter("writer"); //html에 명시한 파라미터 명
	String content=request.getParameter("content"); //html에 명시한 파라미터 명
	
	//클라이언트에 응답할 응답 정보에서 사용할 출력 스트림에 문자열 인수로 넘기기
	//out도 내장객체로 저장되어있다.
	out.print(title+"<br>");//서블릿 에서의 response객체로부터 얻을 수 있는 문자기반 출력스트림
	out.print(writer+"<br>");
	out.print(content+"<br>");
	
	
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
		
		String sql="insert into board(board_id, title, writer, content) values(seq_board.nextval,?,?,?)";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,title);
		pstmt.setString(2,writer);
		pstmt.setString(3,content);
		
		int result = pstmt.executeUpdate();
		if(result==0){
			out.print("등록 실패 <br>");
		}else{
			out.print("등록 성공 <br>");
			out.print("<script>");
			out.print("alert('등록성공');");			
			out.print("location.href='/board/list.jsp';");
			out.print("</script>");
		}
		
		pstmt.close();
		con.close();
	}
	
%>