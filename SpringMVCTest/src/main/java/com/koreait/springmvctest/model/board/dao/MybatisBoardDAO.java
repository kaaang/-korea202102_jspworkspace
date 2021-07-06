package com.koreait.springmvctest.model.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.springmvctest.model.domain.Board;
import com.koreait.springmvctest.model.mybatis.MybatisConfigManager;

public class MybatisBoardDAO implements BoardDAO{
	MybatisConfigManager configManager = MybatisConfigManager.getInstance();
	
	public List selectAll() {
		SqlSession sqlSession = configManager.getSession();
		List list = sqlSession.selectList("Board.selectAll");
		configManager.closeSession(sqlSession);;
		return list;
	}

	public int insert(Board board) {
		SqlSession sqlSession = configManager.getSession();
		int result=sqlSession.insert("Board.insert",board);
		sqlSession.commit();
		configManager.closeSession(sqlSession);
		return result;
	}

	public Board select(int board_id) {
		SqlSession sqlSession = configManager.getSession();
		Board board = sqlSession.selectOne("Board.select",board_id);
		configManager.closeSession(sqlSession);
		return board;
	}

	public int update(Board board) {
		SqlSession sqlSession = configManager.getSession();
		int result = sqlSession.update("Board.update",board);
		sqlSession.commit();
		configManager.closeSession(sqlSession);
		return result;
	}

	public int delete(int board_id) {
		return 0;
	}

}
