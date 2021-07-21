package com.koreait.shoppingmall.model.service.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.shoppingmall.domain.SubCategory;
import com.koreait.shoppingmall.model.repository.category.SubCategoryDAO;

@Service
public class SubCategoryServiceImpl implements SubCategoryService{
	
	@Autowired
	private SubCategoryDAO subCategoryDAO;
	
	public List selectAllById(int topcategory_id) {
		return subCategoryDAO.selectAllById(topcategory_id);
	}

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubCategory select(int subcategory_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(SubCategory subCategory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(SubCategory subCategory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int subcategory_id) {
		// TODO Auto-generated method stub
		
	}

}
