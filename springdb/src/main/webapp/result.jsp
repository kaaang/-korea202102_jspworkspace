<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=request.getAttribute("msg1") %>
<%=session.getAttribute("msg2") %>
<%=application.getAttribute("obj") %>
</body>
</html>