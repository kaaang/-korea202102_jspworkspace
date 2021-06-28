package com.koreait.site0625.model.reboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.site0625.model.domain.ReBoard;
import com.koreait.site0625.model.mybatis.MybatisConfigManager;

public class MybatisReBoardDAO implements ReBoardDAO{
	//쿼리문 수행 객체를 얻기 위한 SqlSessionFactory를 보유한 매니저 선언
	MybatisConfigManager configManager=MybatisConfigManager.getInstance();
	
	
	//등록 후 pk를 반환하는 메서드
	public int insert(ReBoard reboard) {
		SqlSession sqlSession = configManager.getSession();
		
		int result = sqlSession.insert("ReBoard.insert",reboard);
		reboard.setTeam(reboard.getReboard_id());
		sqlSession.update("ReBoard.updateTeam", reboard);
		sqlSession.commit();
		
		configManager.closeSession(sqlSession);
		return result;
	}



	public List selectAll() {
		SqlSession sqlSession = configManager.getSession();
		List list = sqlSession.selectList("ReBoard.selectAll");
		configManager.closeSession(sqlSession);
		return list;
	}

	public ReBoard select(int reboard_id) {
		SqlSession sqlSession = configManager.getSession();
		ReBoard reboard = sqlSession.selectOne("ReBoard.select",reboard_id);
		configManager.closeSession(sqlSession);
		return reboard;
	}

	public int update(ReBoard reBoard) {
		return 0;
	}

	public int delete(int reboard_id) {
		return 0;
	}

	
	

	
	//답변 등록
	public int reply(ReBoard reBoard) {
		SqlSession sqlSession = configManager.getSession();
		
		int result=0;
		try {
			sqlSession.update("ReBoard.updateStep", reBoard);
			//가발자가 따져봐야할 사항은 result가 아닌, 에러가 나지 않은 경우에 아래의 답변을 등록해야한다.
			
			sqlSession.insert("ReBoard.reply", reBoard);		
			sqlSession.commit();
			result=1;
		}catch (Exception e) {
			e.printStackTrace();
			result=0;
		}
		
		configManager.closeSession(sqlSession);
		return result;
	}

}
