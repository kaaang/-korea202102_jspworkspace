package com.koreait.shoppingmall.controller.admin;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("msg","관리자 컨트롤러 호출 테스트");
		
		
		return "admin_result";
	}
	
	//로그인 폼 요청 처리
	@RequestMapping(value = "/loginform", method = RequestMethod.GET)
	public String loginForm() {
		return "admin/login/loginform";
	}
	
	
	//로그인 요청 처리
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Admin admin) {
		return "";
	}
	
	
}
