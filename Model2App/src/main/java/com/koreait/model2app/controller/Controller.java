package com.koreait.model2app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//모든 하위 컨트롤러가 반드시 구현해야할 메서드 정의
public interface Controller {
	//형님으로부터 받은 요청 정보를 이용하여 실제 요청을 처리하는 메서드
	public void excute(HttpServletRequest request, HttpServletResponse response);
	
	//응답시 보여질 결과 페이지
	public String getViewName();
	public boolean isForward();//포워딩 필요 여부를 반환해주는 메서드
}
