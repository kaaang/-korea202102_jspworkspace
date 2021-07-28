package com.koreait.shoppingmall.aop.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;

import com.koreait.shoppingmall.exception.LoginFailException;

//관리자 기능을 이루는 모든 페이지마다, 또는 컨트롤러의 모든 메서드 마다 세션을 검증하는 코드를 일일히 작성하지 말고
//공통 로직으로 두고, AOP를 적용하여서 개발의 효율성을 높이자

//Bell과 같은 녀석
public class AdminSessionCheckAspect2{
	
	//관리자 즉 admin으로 시작하는 모든 요청 URI를 세션의 검증 대상으로 보지 말고, 
	//로그인이 필요치 않는 요청에 대해서만 그냥 가던길 가게 해주자
	
	
	public Object sessionCheck(ProceedingJoinPoint joinPoint) throws Throwable{
		
		Object[] args=joinPoint.getArgs();//타겟 객체의 메서드 요청시 넘어오는 매개변수들을 잡아냄
		HttpServletRequest request=null;
		HttpSession session=null;
		for(Object obj:args) {
			if(obj instanceof HttpServletRequest) {
				request = (HttpServletRequest)obj;
			}
		}
		
		String uri=request.getRequestURI();//포트 번호 뒤에 있는 내용
		
		Object result=null;
		//검증이 필요하지 않는 경우
		if(uri.equals("/admin/loginform") || uri.equals("/admin/login")) {
			result=joinPoint.proceed();
		}else {
		//검증이 필요한 경우
			session=request.getSession();
			if(session.getAttribute("admin")==null) {
				throw new LoginFailException("로그인이 필요한 서비스 입니다.");
			}else {
				result=joinPoint.proceed();
			}
		}
		
		
		
	return result;
	}
	
}
