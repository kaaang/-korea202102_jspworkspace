<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
	<img src="https://cdn0.iconfinder.com/data/icons/small-n-flat/24/678069-sign-error-256.png">
	<%
		RuntimeException e=(RuntimeException)request.getAttribute("e");
		String msg=e.getMessage();
		out.print(msg);
	%>
	<a href="/board/list">메인으로</a>
</body>
</html>