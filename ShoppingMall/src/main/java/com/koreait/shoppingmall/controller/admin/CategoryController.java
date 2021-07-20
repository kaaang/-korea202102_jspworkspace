package com.koreait.shoppingmall.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//관리자가 보게될 상품의 카테고리와 관련된 요청 처리 하위 컨트롤러
@Controller
public class CategoryController {

	
	//카테고리 목록
	@RequestMapping(value = "/admin/category/list", method=RequestMethod.GET)
	public String getCategoryList() {
		
		return null;
	}
	
	
}
