package com.koreait.shoppingmall.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Product {
	private int product_id;
	private int subcategory_id;
	private String product_name;
	private String brand;
	private int price;
	private String info;
	
	MultipartFile photo;
	
}
