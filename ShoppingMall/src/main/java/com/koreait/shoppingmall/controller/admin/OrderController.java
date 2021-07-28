package com.koreait.shoppingmall.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import com.koreait.shoppingmall.exception.LoginFailException;

//관리자 모드의 회원 관리 요청 컨트롤러
@Controller
public class OrderController {

	@GetMapping("/order/list")
	public String getList(HttpServletRequest request) {//HttpServletRequest가 눈에 보이지 않는다고 해서 매개변수로 넘어오지 않은것이 아니다.
		//즉 개발자가 우너할때는 매개변수에 HttpServletRequest, HttpSession을 명시할 수 있다.
		
		return "admin/order/order_list";
	}
	
	
	
	
}
