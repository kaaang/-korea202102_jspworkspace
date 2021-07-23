package com.koreait.shoppingmall.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Product {
	private int product_id;
	private int subcategory_id;
	private SubCategory subCategory;//부모 정보를 has a 관계로 보유한다.
	private String product_name;
	private String brand;
	private int price;
	private String info;
	
	MultipartFile photo;
	private String product_img;
	
	
}
