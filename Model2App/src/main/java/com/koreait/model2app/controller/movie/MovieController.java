package com.koreait.model2app.controller.movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.model.movie.MovieService;

public class MovieController implements Controller{
	MovieService service;
	
	public MovieController() {
		service = new MovieService();
	}
	
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		//혈액형에 판단을 처리
		String movie=request.getParameter("movie");
		String msg=service.getAdvice(movie);
		
		//아직 응답이 처리되지 않은 시점이므로, 동생과 형이 공유하고 있는request객체에 데이터를 넣어두자
		request.setAttribute("msg", msg);
	}

	public String getViewName() {
		return "/movie/result";
	}
	
	@Override
	public boolean isForward() {
		// TODO Auto-generated method stub
		return false;
	}
}
