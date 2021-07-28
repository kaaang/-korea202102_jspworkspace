package com.koreait.shoppingmall.aop.test;

import org.aspectj.lang.ProceedingJoinPoint;

//어플리케이션 어디에서나 사용 가능한 공통 로직
public class Bell {
	
	//공통 로직
	//공통 로직을 around advice로 호출할 경우, 원래 호출하려 했던 메서드를 도달하기전
	//각종 정보를 낚아챌 수 있다..
	//이때 각정 정보를 가진 객체가 바로 PRoceedingJoinPoint이다.
	public void sound(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("호출 전 딩동댕♬");
		
		Object target=joinPoint.getTarget();
		System.out.println("중간에 낚아채서 알아낸 정보 중 원래 호출될 객체는 "+target);
		
		//원래 호출 하려던 타겟 객체의 메서드의 매개변수로 알아맞춰보자
		String methodName=joinPoint.getSignature().getName();
		System.out.println("원래 호출 하려고 했던 메서드 명은 "+methodName);
		
		Object[] args=joinPoint.getArgs();
		for(Object obj:args) {
			System.out.println(obj);
		}
		
		//원래 호출 하려 했던 메서드 다시 호출 재개
		joinPoint.proceed();
		System.out.println("호출 후 딩동댕♬");
		
		
		
	}
}
