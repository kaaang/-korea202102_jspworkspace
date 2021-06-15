package study;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;


public class TestServlet extends HttpServlet{
	//요청에 대한 응답을 처리해보자 -> ㅅservice() 메서드가 요청 및 응답을 처리
	//들어온 요청에 대해 응답정보 및 스트림을 가진 응답객체로 매개변수로 넘겨받는다.
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//스트링을 뽑기 전에 미리 인코딩 처리 하자
		response.setContentType("text/html");//mimetype지정
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();//문자 기반의 출력스트림을 반환하는 메서드
		out.print("this is my second Sevlet !!");
	}
}
