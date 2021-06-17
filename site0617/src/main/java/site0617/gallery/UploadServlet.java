package site0617.gallery;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//이미 jsp로도 업로드 처리가 가능하겠으나, 서블리을 다시한번 공부해보고자 이 클래스를 작성하는것임
public class UploadServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("제가 업로드 처리할게요");
		
		
		request.setCharacterEncoding("utf-8");
		
		
	}
}
