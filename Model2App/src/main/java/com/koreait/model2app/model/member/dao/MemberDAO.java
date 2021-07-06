package com.koreait.model2app.model.member.dao;

import java.util.List;

import com.koreait.model2app.model.domain.Member;

//모든~하위 MemberDAO가 반드시 구현해야 할 메서드 정의
public interface MemberDAO {
	//회원등록
	public int insert(Member member);
	//회원목록
	public List selectAll();
	//회원상세정보
	public Member select(int member_id);
	//회원수정
	public int update(Member member);
	//회원삭제
	public int delete(int member_id);
}
