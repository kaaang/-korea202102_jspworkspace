<%@ page contentType="text/html;charset=utf-8"%>

<%
/*
jsp란? : Java Server Page : 자바 기술로 오직 서버에서만 실행되는 파일
		결론 : 우리가 알고있는 javaSE에 사용했던 문법이 그대로 사용될 수 있따.

		-jsp파일의 작성 영역 (4가지)
		(1)지시영역 (필수) - 현재 페이지에 대한 정보 및 설정, 응답시 head정보를 구성한다
		(2)선언부 (선택)
		(3)스크립틀릿 (필수) [%영역%]
								-로직을 작성하는 영역, 즉 클래스의 인스턴스 메서드 영역
		(4)표현식 (선택)
*/

	out.print("나의 my jsp<br>");//node.js 에서의 response.end() 응답정보 전송
	for(int i=1;i<=9;i++){
		out.print("3*"+i+"="+(3*i)+" <br>");
	}
	


%>