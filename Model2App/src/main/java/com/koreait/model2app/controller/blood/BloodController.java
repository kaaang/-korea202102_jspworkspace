package com.koreait.model2app.controller.blood;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.model.blood.BloodService;

public class BloodController implements Controller{
	BloodService service;
	
	public BloodController() {
		service = new BloodService();
	}
	
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		//혈액형에 판단을 처리
		String blood=request.getParameter("blood");
		String msg=service.getAdvice(blood);
		
		//아직 응답이 처리되지 않은 시점이므로, 동생과 형이 공유하고 있는request객체에 데이터를 넣어두자
		request.setAttribute("msg", msg);
	}

	public String getViewName() {
		return "/blood/result";
	}
	@Override
	public boolean isForward() {
		// TODO Auto-generated method stub
		return false;
	}

}
