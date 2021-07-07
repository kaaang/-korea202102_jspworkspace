package com.koreait.springmvc0707.model.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.springmvc0707.model.domain.Board;
import com.koreait.springmvc0707.model.mybatis.MybatisConfigManager;

import lombok.Setter;

@Setter
public class MybatisBoardDAO implements BoardDAO{
	
	private MybatisConfigManager configManager;

	public List selectAll() {
		SqlSession sqlSession = configManager.getSession();
		List boardList = sqlSession.selectList("Board.selectAll");
		configManager.closeSession(sqlSession);
		return boardList;
	}

	public void insert(Board board) {
		
	}

	public Board select(int board_id) {
		SqlSession sqlSession = configManager.getSession();
		Board board = sqlSession.selectOne("Board.select",board_id);
		configManager.closeSession(sqlSession);
		return board;
	}

	public void update(Board board) {
		
	}

	public void delete(int board_id) {
		
	}

}
