package com.koreait.shoppingmall.model.repository.admin;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.shoppingmall.domain.Admin;
import com.koreait.shoppingmall.exception.MemberExistException;


@Repository
public class MybatisAdminDAO implements AdminDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public Admin login(Admin admin) throws MemberExistException{
		Admin obj = sqlSessionTemplate.selectOne("Admin.login",admin);
		if(obj==null) {
			throw new MemberExistException("관리자 정보가 올바르지 않습니다.");
		}
		return obj;
	}

	public void regist(Admin admin) {
		
	}

	public void update(Admin admin) {
		
	}

	public void delete(Admin admin) {
		
	}

	public List selectAll() {
		return null;
	}

}
