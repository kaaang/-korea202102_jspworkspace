<%@page import="com.koreait.shoppingmall.domain.SubCategory"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	//이 jsp는 디자이능ㄹ 응답정보로 보내기 위함이 아니라, json데이터를 응답정보로 보내기 위한 페이지
	List<SubCategory> sublist=(List)request.getAttribute("sublist");

	//List --> Json데이터로 변환해서 클라이언트에게 응답정보로 전송해야한다.
	
	//방법1-json string 을 직접 작성하는법
	//방법2-java객체 <--> json자동변환 라이브러리 Gson
%>