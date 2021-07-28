package com.koreait.shoppingmall.aop.admin;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;

import com.koreait.shoppingmall.exception.LoginFailException;

//관리자 기능을 이루는 모든 페이지마다, 또는 컨트롤러의 모든 메서드 마다 세션을 검증하는 코드를 일일히 작성하지 말고
//공통 로직으로 두고, AOP를 적용하여서 개발의 효율성을 높이자

//Bell과 같은 녀석
public class AdminSessionCheckAspect{
	
	public void sessionCheck(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("sessionCheck 감시 메서드 작동됨");
		System.out.println("원래 호출하려고 했던 메서드는 : "+joinPoint.getSignature().getName());
		
		
		
		HttpSession session=null;
		//하위 컨트롤러들에게는 이미 HttpServletRequest가 전달되고 있다는것을 증명하겠다.
		Object[] args=joinPoint.getArgs();//컨트롤러 메서드 호출 시 넘어오는 모든 매개변수를 잡아내자
		for(Object obj:args) {
			System.out.println(obj);
			if(obj instanceof HttpSession) {//obj가 HttpSession의 자료형일때만 담겠다
				session=(HttpSession)obj;
			}
		}
		
		//추출한 세션 안에 Admin VO가 존재한다면, 로그인 검증이 완료된 유저임
		if(session.getAttribute("admin")==null) {
			//뒤로, 로그임 폼으로 돌려보내야함 즉 관리자 모드에 접근하지 못하도록
			//예외를 발생시키자
			throw new LoginFailException("로그인이 필요한 서비스 입니다.");
		}else {
			joinPoint.proceed();
		}
		
		
	}
}
