<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//현재 클라이언트가 사영중인 session 객체를 무효화 시키자 즉 기존 세션을 더이상 사용 못하게 처리
	session.invalidate();
%>
<script type="text/javascript">
	alert("로그아웃 처리 되었습니다.");
	location.href="/member/login.jsp";
</script>