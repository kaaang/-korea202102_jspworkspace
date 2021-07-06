package com.koreait.model2app.model.member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.koreait.model2app.model.domain.Member;

//회원과 관련된 비지니스 로직을 수행하는 서비스 정의
//서비스는 Model파트의 객체이다, 만일 서비스의 존재가 없다면, 많은 업무를 Controller가 부담하게 된다.
//또한 서비스가 없다면 물리적으로 분리된 DAO간에 트랜잭션을 처리할 수 없다.
public interface MemberService {
	//회원 등록
	public void regist(Member member, HttpServletRequest request);
	//회원 목록
	public List selectAll();
	//회원 상세 정보
	public Member select(int member_id);
	//회원 수정
	public int update(Member member);
	//회원 삭제
	public int delete(int member_id);
}
