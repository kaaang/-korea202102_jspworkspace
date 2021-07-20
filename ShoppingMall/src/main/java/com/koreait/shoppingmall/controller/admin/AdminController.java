package com.koreait.shoppingmall.controller.admin;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.shoppingmall.domain.Admin;
import com.koreait.shoppingmall.exception.MemberExistException;
import com.koreait.shoppingmall.model.service.admin.AdminService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private AdminService adminService;
	
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
	public String login(Admin admin,HttpSession session) {
		logger.info("아이디 {}",admin.getName());
		
		//일시키기
		Admin obj=adminService.login(admin);
		//저장
		session.setAttribute("admin",obj);
		return "admin/main/index";
	}
	
	
	
	
	
	//위의 요청을 처리하는 메서드 중에서, 어느것 하나라도 예외가 발생하면 아래의 메서드가 동작하게 됨
	@ExceptionHandler(MemberExistException.class)
	public String handleException(MemberExistException e, Model model) {
		model.addAttribute("e",e);
		return "error/result";
	}
	
}
