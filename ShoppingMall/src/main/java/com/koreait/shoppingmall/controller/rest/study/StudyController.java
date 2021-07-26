package com.koreait.shoppingmall.controller.rest.study;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.shoppingmall.domain.Member;

import lombok.Delegate;

//RESTful 요청을 처리하기 위한 연습용 컨트롤러
@RestController
public class StudyController {
	
	//멤버 목록에 대한 요청 처리
	@GetMapping("/member")
	//@ResponseBody //이 어노테이션을 명시하면, ViewPesolver에 의해 jsp매핑이 일어나지 않는다.
	public List<Member> getList(){
		Member m1 = new Member();
		m1.setMember_id(1);
		m1.setUser_id("kang");
		m1.setPass("1234");
		m1.setName("shin");
		
		Member m2 = new Member();
		m2.setMember_id(1);
		m2.setUser_id("kkang");
		m2.setPass("1234");
		m2.setName("sshin");
		
		List<Member> list = new ArrayList<Member>();
		list.add(m1);
		list.add(m2);
		
		
		return list;
	}
	
	
	@GetMapping("/member/{member_id}") //경로에 불과했던 member_id를 실제 변수화 시켜주기 위해서는
	//@ResponseBody								//아래와같이 써야한다.
	public Member getDetail(@PathVariable int member_id) {//url의 일부가아닌, RESTful에서의 변수임을 알려줘야한다.
		System.out.println("member_id="+member_id);
		Member m = new Member();
		
		m.setMember_id(member_id);
		m.setUser_id("King");
		m.setPass("9999");
		m.setName("king");
		return m;
	}
	
	//폼 양식으로부터 글 등록 요청 처리
	/*
	//글 등록 요청(post)처리
	@PostMapping("/member")
	//@ResponseBody
	public Member regist(Member member) {
		
		
		return member;
	}
	*/
	
	/*{"member_id":24} 형식의 문자열로 전송되어옴
	 * 일반적으로 특별한 처리를 하지 않는 한, VO매핑은 쿼리스트링만을 매핑시킨다
	 * 즉 json문자열과의 매핑은 일어나지 않음
	 * 해결책 : @RequestBody : 제이슨 문자열을 자바객체와 매핑시켜줌*/
	@PostMapping("/member")
	public Member regist(@RequestBody Member member) {
		System.out.println("이름은 "+member.getName());
		return member;
	}
	
	
	
	//글 수정 요청(put)처리
	@PutMapping("/member")
	//@ResponseBody
	public Member update(@RequestBody Member member) {
		System.out.println("put요청 처리함");
		
		return member;
	}
	
	
	@DeleteMapping("/member")
	public Member delete(@RequestBody Member member) {
		System.out.println("delete 요청 처리");
		return member;
	}
	
	
}
