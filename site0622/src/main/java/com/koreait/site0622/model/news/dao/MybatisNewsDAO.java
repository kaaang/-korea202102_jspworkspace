package com.koreait.site0622.model.news.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.site0622.model.domain.News;
import com.koreait.site0622.model.mybatis.MybatisConfigManager;

public class MybatisNewsDAO implements NewsDAO{
	MybatisConfigManager configManager = MybatisConfigManager.getInstance();

	public int insert(News news) {
		SqlSession sqlSession = configManager.getSession();
		int result = sqlSession.insert("News.insert",news);
		sqlSession.commit();
		configManager.closeSession(sqlSession);
		return result;
	}

	public List selectAll() {
		SqlSession sqlSession = configManager.getSession();
		List list = sqlSession.selectList("News.selectAll");
		configManager.closeSession(sqlSession);
		return list;
	}

	public News select(int news_id) {
		SqlSession sqlSession = configManager.getSession();
		News news = sqlSession.selectOne("News.select",news_id);
		configManager.closeSession(sqlSession);
		return news;
	}

	public int update(News news) {
		return 0;
	}

	public int delete(int news_id) {
		return 0;
	}

}
