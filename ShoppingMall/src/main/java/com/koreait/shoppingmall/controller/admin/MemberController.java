package com.koreait.shoppingmall.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//관리자 모드의 회원 관리 요청 컨트롤러
@Controller
public class MemberController {

	//회원관리 목록 요청
	@GetMapping("/member/list")
	public String getList(HttpServletRequest request) {
		
		return "admin/member/member_list";
	}
}
