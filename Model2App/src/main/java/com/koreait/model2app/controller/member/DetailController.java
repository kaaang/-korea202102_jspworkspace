package com.koreait.model2app.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.model.member.service.MemberService;
import com.koreait.model2app.model.member.service.MemberServiceImpl;



//회원 상세 정보 요청을 처리할 하위 컨트롤러
public class DetailController implements Controller{

	MemberService memberService;
	
	public DetailController() {
		memberService = new MemberServiceImpl();
	}
	
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		int member_id=Integer.parseInt(request.getParameter("member_id"));
		memberService.select(member_id);
	}

	public String getViewName() {
		return null;
	}

	public boolean isForward() {
		return false;
	}

}
