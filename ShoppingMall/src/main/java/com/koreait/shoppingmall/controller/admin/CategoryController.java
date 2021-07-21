package com.koreait.shoppingmall.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.shoppingmall.domain.SubCategory;
import com.koreait.shoppingmall.model.service.category.SubCategoryService;
import com.koreait.shoppingmall.model.service.category.TopCategoryService;

//관리자가 보게될 상품의 카테고리와 관련된 요청 처리 하위 컨트롤러
@Controller
public class CategoryController {
	@Autowired
	private TopCategoryService topCategoryService;
	@Autowired
	private SubCategoryService subCategoryService;
	
	//카테고리 목록
	@RequestMapping(value = "/category/list", method=RequestMethod.GET)
	public String getCategoryList(Model model) {
		List topList=topCategoryService.getSubCount();
		model.addAttribute("topList",topList);
		return "admin/category/index";
	}
	
	
	//상위카테고리의 상세 내역 요청
	@RequestMapping(value = "/category/topdetail", method=RequestMethod.GET)
	@ResponseBody
	public List<SubCategory> getTopDetail(int topcategory_id,Model model) {
		List subList=subCategoryService.selectAllById(topcategory_id);
		//model.addAttribute("subList",subList);
		
		//jsp를 통해서가 아니라, 현재 요청 메서드에 응답자체를 json, xml등으로 처리할 수 있는 방법
		//자가 객체를 자동으로 json표기법으로 String화시켜서 자동 변환해주는 라이브러리를 스프링은 이용할 수 있다.
		
		
		return subList;
	}
	
	
}
