package com.koreait.shoppingmall.model.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.shoppingmall.domain.Product;
import com.koreait.shoppingmall.exception.DMLException;
import com.koreait.shoppingmall.model.repository.product.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDAO productDAO;
	
	
	@Override
	public List selectAll() {
		return productDAO.selectAll();
	}

	@Override
	public Product select(int product_id) {
		return productDAO.select(product_id);
	}

	@Override
	public void regist(Product product) throws DMLException{
		productDAO.insert(product);
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int product_id) throws DMLException{
		productDAO.delete(product_id);
		
	}
	@Override
	public List selectBySubCategory(int subcategory_id) {
		return productDAO.selectBySubCategory(subcategory_id);
	}

}
