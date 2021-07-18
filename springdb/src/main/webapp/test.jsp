<%@ page contentType="text/html;charset=UTF-8"%>
<%
	request.setAttribute("msg1", "요청 객체 데이터");
	session.setAttribute("msg2", "세션 객체 데이터");
	application.setAttribute("msg3", "어플리케이션 객체 데이터");
	
	

%>
<a href="/result.jsp">심기 완료</a>