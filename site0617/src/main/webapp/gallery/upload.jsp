<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	//스크립틀릿 == service 메서드 영역
	//out.print("제가 업로드 처리할게요<br>");

	//클라이언트가 일반폼이 아닌, 바이너리 데이터가 포함된 데이터를 전송할 경우
	//즉 form태그에 enctype를 multipart/form-dataㄹ ㅗ지정하여 전송할경우, 서버에서는 파일을 처리할 수 있는 방법으로 요청을 처리해야한다.

	request.setCharacterEncoding("utf-8");
	//String title = request.getParameter("title");
	//String writer = request.getParameter("writer");
	//String content = request.getParameter("content");
	//String myfile = request.getParameter("myfile");//얘는 파일 자체가 아님
	
	//업로드 처리 객체인Mutlpartrequest를 사용해보자
	String path="D:/korea202102_jspworkspace/site0617/src/main/webapp/data";
	MultipartRequest multi = new MultipartRequest(request,path);
	out.print("업로드 완료");
	
	//out.print(title+"<br>");
	//out.print(writer+"<br>");
	//out.print(content+"<br>");
	//out.print(myfile+"<br>");
	
%>