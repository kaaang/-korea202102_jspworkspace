package com.koreait.shoppingmall.domain;

import java.util.List;

import lombok.Data;

@Data
public class TopCategory {
	private int topcategory_id;
	private String top_name;
	private int cnt;

	// 부모가 거느리고 있는 자식 객체들을 보유할 객체 선언
	private List<SubCategory> subList;
}
