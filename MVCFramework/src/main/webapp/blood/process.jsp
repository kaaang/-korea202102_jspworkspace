<%@page import="com.koreait.mvcframework.model.blood.BloodService"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%!
	BloodService service=new BloodService();
%>
<%
	//컨트롤러는 디자인과 로직을 분리 시키기 위한 중간 처리자(프로그램 흐름을 처리)
	//요청을 받아서, 적잘한 로직 객체에게 일을 시키고, 적절한 결과 페이지를 보여줄 흐름을 처리

	//클라이언트가 전송한 파라미터를 받아 결과 보여주기
	request.setCharacterEncoding("utf-8");	
	String blood = request.getParameter("blood");

	//이미 기존에 작성해 두었던 로직을 재사용한다(모델)
	String msg = service.getAdvice(blood);
	
	request.setAttribute("msg", msg);
	
	//이후 응답하면 안되고 요청, 응답 객체를 그대로 포워딩 해줘야함(전달)
	//response.sendRedirect("/blood/result.jsp");//지정한 url을 재 요청
	//위와같이 요청을 끊고, 클라이언트가 재접속 하게 하지 말고
	//서버에서 특정 자원으로 요청을 포워딩 즉 전달시켜보자
	
	RequestDispatcher dis=request.getRequestDispatcher("/blood/result.jsp");
	dis.forward(request, response);
%>

