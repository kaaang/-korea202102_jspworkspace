package test;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
//jsp업이도, 웹 서버측의 기술을 구현할 수 있고, 아래와 같이 서버에서 해석 및 실행되는 클래스를 카리켜 서블릿(Servlet)라 하며
//javaEE -- 


//서블릿은 생명주기 메서드라 불리는 주요 메서드가 존재하며, 이 생명주기 메서드는 하나의 서블릿 객체가 태어나서 일하며, 소멸하는 과정과 관련한 주요 메서드 이다.

//서블릿 클래스의 위치가 WEB-INF/classes이므로, 웹 브라우저의 url로 직접 호출할 수 없고, 매핑(mapping)을 이용한다.
public class MyServlet extends HttpServlet{
	//서블릿 인스턴스가 태어난 후, 서블릿의 초기화 작업시 호출되는 메서드
	public void init(){
		System.out.println("Hello, i'm reset complite");
	}
	//초기화를 완료한 서블릿이, 웹 클라이언트의 요청을 처리할때 동작하는 메서드
	public void service(HttpServletRequest request, HttpServletResponse response){
		System.out.println("Client request....");

		//웹 브라우저에 응답정보를 구성하여 응답하기
		try{
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();//클라이언트와 연결된 출력스트림
			out.print("my servlet test is successful!!");
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}
	//서블릿이 소멸할때 호출되는 메서드
	public void destory(){
		System.out.println("Bye...");
	}
}