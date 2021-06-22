package com.koreait.site0622.model.board.dao;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.site0622.model.domain.Board;
import com.koreait.site0622.model.mybatis.MybatisConfigManager;

//mybatis를 이용한다고 해서 DAO가 사라지는것이 아니라, DAO의 역할은 그래도 유지
//단, DAO가 사용하려는 기술이 JDBC, Mybatis, Hibernate, JPA등등 인것 뿐
public class MybatisBoardDAO implements BoardDAO{
	MybatisConfigManager configManager = MybatisConfigManager.getInstance();
	
	
	//등록
	public int insert(Board board) {
		//mybatis 이용해보자
		SqlSession sqlSession = configManager.getSession();
		int result = sqlSession.insert("Board.insert",board);
		sqlSession.commit();
		configManager.closeSession(sqlSession);
		return result;
	}
	
	
	//모든 레코드 가져오기
	public List selectAll() {
		SqlSession sqlSession = configManager.getSession();
		List list = sqlSession.selectList("Board.selectAll");
		configManager.closeSession(sqlSession);
		return list;
	}
	
	
	//레코드 한건 가져오기
	public Board select(int board_id) {
		SqlSession sqlSession = configManager.getSession();
		Board board = sqlSession.selectOne("Board.select",board_id);
		configManager.closeSession(sqlSession);
		return board;
	}
	
	
	//수정하기
	public int update(Board board) {
		SqlSession sqlSession = configManager.getSession();
		//DML인 경우 commit
		int result = sqlSession.update("Board.update", board);
		sqlSession.commit();
		configManager.closeSession(sqlSession);
		return result;
	}
	
	
	//삭제하기
	public int delete(int board_id) {
		SqlSession sqlSession = configManager.getSession();
		//DML인 경우 commit
		int result = sqlSession.delete("Board.delete", board_id);
		sqlSession.commit();
		configManager.closeSession(sqlSession);
		return result;
	}
	
}
