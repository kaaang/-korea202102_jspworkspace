package com.koreait.shoppingmall.model.study;

import org.springframework.stereotype.Component;


public class StudentImpl implements Student{

	@Override
	public void getup(int time) {
		System.out.println(time+"기상");
	}

	@Override
	public void study(String subject) {
		System.out.println(subject+"공부");
	}

	@Override
	public void sleep() {
		System.out.println("취침");
	}

}
