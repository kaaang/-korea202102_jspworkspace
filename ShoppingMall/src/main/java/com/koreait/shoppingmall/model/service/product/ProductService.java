package com.koreait.shoppingmall.model.service.product;

import java.util.List;

import com.koreait.shoppingmall.domain.Product;

public interface ProductService {
	public List selectAll();
	public Product select(int product_id);
	public void regist(Product product);
	public void update(Product product);
	public void delete(int product_id);
	public List selectBySubCategory(int subcategory_id);

}
