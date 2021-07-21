package com.koreait.shoppingmall.model.repository.category;

import java.util.List;

import com.koreait.shoppingmall.domain.TopCategory;

public interface TopCategoryDAO {
	public List getSubCount();
	public List selectAll();
	public void insert(TopCategory topCategory);
	public TopCategory select(int topCategory_id);
	public void update(TopCategory topCategory);
	public void delete(int topCategory_id);
}
