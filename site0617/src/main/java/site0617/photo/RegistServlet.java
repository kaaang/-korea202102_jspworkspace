package site0617.photo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//아파치 업로드 컴포넌트를 이용한 파일업로드 구현
public class RegistServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//jsp에서의 page지시영역의 conentType과 동일
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("저 실행성공이요~!");
		
		//아파치 파일 업로드를 이용한 파일업로드 처리~~
		
		
	}
}
