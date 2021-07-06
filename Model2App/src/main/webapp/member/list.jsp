<%@page import="com.koreait.model2app.model.domain.Member"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	List<Member> memberList = (List)request.getAttribute("memberList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table width="100%" border="1px">
		<tr>
			<th>이미지</th>
			<th>이름</th>
			<th>연락처</th>
			<th>주소</th>
		</tr>
		
		
		<%for(Member member : memberList){ %>
		<tr>
			<td>
				<img src="/data/<%=member.getPhoto() %>" width="45px">
			</td>
			<td>
				<a href="/member/detail.do?member_id="<%= member.getMember_id()%>><%=member.getName() %></a>
			</td>
			<td><%=member.getPhone() %></td>
			<td><%=member.getAddr() %></td>
		</tr>
		<%} %>
		<tr>
			<td colspan="4"><button onclick="location.href='/member/regist.jsp';">회원 등록</button></td>
		</tr>
		
		
		
	</table>

</body>
</html>