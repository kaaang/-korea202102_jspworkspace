package com.koreait.shoppingmall.model.repository.category;

import java.util.List;

import com.koreait.shoppingmall.domain.SubCategory;

public interface SubCategoryDAO {
	public List selectAllById(int topcategory_id);
	public List selectAll();
	public SubCategory select(int subcategory_id);
	public void insert(SubCategory subCategory);
	public void update(SubCategory subCategory);
	public void delete(int subcategory_id);
}
