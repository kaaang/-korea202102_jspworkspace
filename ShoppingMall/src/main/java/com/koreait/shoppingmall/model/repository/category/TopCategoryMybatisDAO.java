package com.koreait.shoppingmall.model.repository.category;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.shoppingmall.domain.TopCategory;

@Repository
public class TopCategoryMybatisDAO implements TopCategoryDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List getSubCount() {
		return sqlSessionTemplate.selectList("TopCategoryCount.getSubCount");
	}

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(TopCategory topCategory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TopCategory select(int topCategory_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(TopCategory topCategory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int topCategory_id) {
		// TODO Auto-generated method stub
		
	}

}
