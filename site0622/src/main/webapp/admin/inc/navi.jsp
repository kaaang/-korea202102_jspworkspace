<%@page import="com.koreait.site0622.model.domain.Member"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	Member member = (Member)session.getAttribute("member");
%>
현재 [<%=member.getName() %>] 로그인 중
<div class="topnav">
  <a class="active" href="/admin/main.jsp">Home</a>
  <a href="/admin/member/list.jsp">회원 관리</a>
  <a href="/admin/comments/list.jsp">코멘트게시판</a>
  <a href="/admin/member/logout.jsp">로그아웃</a>
</div>
