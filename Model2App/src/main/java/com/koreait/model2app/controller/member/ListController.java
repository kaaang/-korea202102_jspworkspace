package com.koreait.model2app.controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.model.member.service.MemberService;
import com.koreait.model2app.model.member.service.MemberServiceImpl;

public class ListController implements Controller{
	MemberService memberService;
	
	public ListController() {
		memberService = new MemberServiceImpl();
	}

	public void excute(HttpServletRequest request, HttpServletResponse response) {
		List memberList = memberService.selectAll();
		
		request.setAttribute("memberList", memberList);
	}

	public String getViewName() {
		return "/result/member/list";
	}

	public boolean isForward() {
		return true;
	}

}
