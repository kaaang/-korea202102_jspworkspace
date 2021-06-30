package com.koreait.mvcframework.controller.movie;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.mvcframework.controller.Controller;
import com.koreait.mvcframework.model.movie.MovieService;


//영화에 대한 요청을 처리하는 컨트롤러
public class MovieController implements Controller{
	MovieService service;
	
	public MovieController() {
		service = new MovieService();
	}
	
	public void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movie=request.getParameter("movie");
		
		
		//로직은 재사용 가능성이 있으므로, 컨트롤러에 국한시키지 말고, 별도의 물리적 파일로 분리 
		String msg=service.getAdvice(movie);
		
		//4.결과 request에 심기!!
		request.setAttribute("msg", msg);
		
		//이후 여기서 디자인 처리가 가능하긴 하지만, 유지 보수성이 떨어지므로 디자인은 별도의 jsp에서 담당하자
	
		
	}
	
	
	public String getViewName() {
		return "/movie/result.jsp";
	}
	
	
}
