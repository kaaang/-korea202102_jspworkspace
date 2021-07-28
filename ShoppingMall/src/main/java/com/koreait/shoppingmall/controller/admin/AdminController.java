package com.koreait.shoppingmall.controller.admin;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String loginForm(HttpServletRequest request) {
		return "admin/login/loginform";
	}
	
	
	//로그인 요청 처리
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Admin admin,HttpServletRequest request) {
		logger.info("아이디 {}",admin.getName());
		
		//일시키기
		Admin obj=adminService.login(admin);
		//저장
		HttpSession session=request.getSession();
		session.setAttribute("admin",obj);
		return "redirect:/admin/main";
	}
	
	//관리자 메인 페이지 요청
	@GetMapping("/main")
	public String getMain(HttpServletRequest request) {
		return "admin/main/index";
	}
	
	
	
	
	
	
	
}
