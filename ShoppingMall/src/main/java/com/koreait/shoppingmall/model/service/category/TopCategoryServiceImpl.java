package com.koreait.shoppingmall.model.service.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.shoppingmall.domain.TopCategory;
import com.koreait.shoppingmall.model.repository.category.TopCategoryDAO;

@Service
public class TopCategoryServiceImpl implements TopCategoryService{
	@Autowired
	private TopCategoryDAO topCategoryDAO;

	@Override
	public List getSubCount() {
		return topCategoryDAO.getSubCount();
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
