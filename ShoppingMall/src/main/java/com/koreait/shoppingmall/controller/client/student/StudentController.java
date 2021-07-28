package com.koreait.shoppingmall.controller.client.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.shoppingmall.model.study.Student;

@Controller
public class StudentController {
	@Autowired
	private Student student;
	
	@GetMapping("/aop/test")
	@ResponseBody
	public String test() {
//		student.getup(8);
		student.study("JAVA");
//		student.sleep();
		return "aop 실행";
	}
	
}
