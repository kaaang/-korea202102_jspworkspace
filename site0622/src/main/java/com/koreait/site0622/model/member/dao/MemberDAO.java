package com.koreait.site0622.model.member.dao;

import java.util.List;

import com.koreait.site0622.model.domain.Member;

public interface MemberDAO {
	//아이디 체크
	public Member getMemberById(String id);
	
	//회원가입
	public int regist(Member member);
	
	//회원삭제
	public int delete(Member member);
	
	
	//회원 목록
	public List selectAll();
	
	
	//회원 1명 조회
	public Member select(int member_id);
	
	//아이디 비밀번호 회원정보 가져오기
	public Member select(Member member);

	
	//회원 수정
	public int update(Member member);
	
	
}
