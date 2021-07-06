package com.koreait.model2app.model.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.koreait.model2app.exception.LicenseRegistException;
import com.koreait.model2app.model.domain.License;
import com.koreait.model2app.model.domain.Member;
import com.koreait.model2app.model.license.dao.JdbcLicenseDAO;
import com.koreait.model2app.model.license.dao.LicenseDAO;
import com.koreait.model2app.model.member.dao.JdbcMemberDAO;
import com.koreait.model2app.model.member.dao.MemberDAO;
import com.koreait.model2app.util.FileManager;
import com.koreait.model2app.util.pool.PoolManager;

//서비스 인터페이스를 구현한 구현 클래스
//왜 서비스에 인터페이까지 둬야 하는지 의문지 생기겠지만, 담주까지 참자,,
//이유 : 어플리케이션의 의존성을 약화시키기 위함
public class MemberServiceImpl implements MemberService{

	private PoolManager pool = PoolManager.getInstance();//DAO들사이의 Connection을 공유하기 위헤
	
	
	
	//부장님이 일 시킬 모델 객체들
	FileManager fileManager;//파일 업로드
	MemberDAO memberDAO;//회원 정보
	LicenseDAO licenseDAO;//자격증 정보
	
	
	public MemberServiceImpl() {
		memberDAO = new JdbcMemberDAO();
		licenseDAO = new JdbcLicenseDAO();
	}
	
	
	
	public void regist(Member member,HttpServletRequest request) throws LicenseRegistException{
		Connection con = pool.getConnection();//DAO들에게 나누어줄 커넥션 얻기
		((JdbcMemberDAO)memberDAO).setCon(con);
		((JdbcLicenseDAO)licenseDAO).setCon(con);
		
		//jdbc에서의 connection은 autoCommit이 true로 설정되어 있기 때문에 오라클과 틀리다
		//일단 autocommit=false로 돌려놓고 트랜잭션 작업하자.
		try {
			con.setAutoCommit(false);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		try {
			int member_id=memberDAO.insert(member);
			
			
			List<License> list = member.getList();
			for(License obj : list) {
				obj.setMember_id(member_id);//회원 등록시 발생한 시퀀스 값을 대입해야 함
				licenseDAO.insert(obj);
			}
			try {
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (LicenseRegistException e) {
			System.out.println(e.getMessage());//에러 메시지 출력(유저들을 위한 비전문 메세지)
			e.printStackTrace();//개발자가 원인은 분석하기 위한 stack구조의 에러 콘솔 출력
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw e;//에러가 발생
		}finally {
			pool.release(con);
			try {
				con.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	

	public List selectAll() {
		Connection con = pool.getConnection();
		((JdbcMemberDAO)memberDAO).setCon(con);
		
		List list=memberDAO.selectAll();
		pool.release(con);
		
		return list;
	}

	public Member select(int member_id) {
		Connection con = pool.getConnection();
		((JdbcMemberDAO)memberDAO).setCon(con);
		
		Member member=memberDAO.select(member_id);
		pool.release(con);
		
		return member;
	}

	public int update(Member member) {
		return 0;
	}

	public int delete(int member_id) {
		return 0;
	}

	

}
