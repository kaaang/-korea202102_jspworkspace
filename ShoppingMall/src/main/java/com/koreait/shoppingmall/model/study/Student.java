package com.koreait.shoppingmall.model.study;


//학생을 느슨하게 보유하기 위해 인터페이스로 정의
public interface Student {
	public void getup(int time);
	public void study(String subject);
	public void sleep();

}
