package com.koreait.springmvc0715.model.board.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.springmvc0715.exception.DMLException;
import com.koreait.springmvc0715.model.domain.Board;

import lombok.Setter;

@Setter
@Repository
public class MybatisBoardDAO implements BoardDAO{
	@Autowired
	private SqlSessionTemplate sessionTemplate;

	public List selectAll() {
		List boardList=sessionTemplate.selectList("Board.selectAll");
		return boardList;
	}

	public void insert(Board board) throws DMLException{//여기서 에러를 처리해버리면 미궁에 빠짐 뷰단까지 에러의 원인을 전달해야 한다 그래야 사용자들이 에러가 났음을 이애한다. 개발자는 적절한 에러 처리를 할 수 있다.(에러 페이지 이동)
		sessionTemplate.insert("Board.insert", board);//자동 커밋처리
	}

	public Board select(int board_id) {
		return sessionTemplate.selectOne("Board.select",board_id);
	}

	public void update(Board board) throws DMLException{
		sessionTemplate.update("Board.update", board);
	}

	public void delete(int board_id) throws DMLException{
		sessionTemplate.delete("Board.delete", board_id);
	}

}
