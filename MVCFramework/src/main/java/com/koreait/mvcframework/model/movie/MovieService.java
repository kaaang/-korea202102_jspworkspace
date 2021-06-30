package com.koreait.mvcframework.model.movie;


//영화에 대한 조언을 판단하는 모델객체(플렛폼에 중립적이다. 따라서 웹, 응용 모두 사용가능==재사용성)
public class MovieService {
	public String getAdvice(String movie) {
		String msg=null;
		
		if(movie.equals("미션임파서블")) {
			msg="톰 크르주의 최고 앱션 첩보 영화";
		}else if(movie.equals("크루엘라")) {
			msg="디즈니의 명작";
		}else if(movie.equals("어바웃타임")) {
			msg="마블의 히어로";
		}else if(movie.equals("어벤져스")) {
			msg="멜로";
		}
		
		
		return msg;
	}
}
