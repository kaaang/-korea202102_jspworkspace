package com.koreait.shoppingmall.model.repository.product;

import java.util.List;

import com.koreait.shoppingmall.domain.Product;


public interface ProductDAO {
	public List selectAll();
	public Product select(int product_id);
	public void insert(Product product);
	public void update(Product product);
	public void delete(int product_id);


}
