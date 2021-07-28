package com.koreait.shoppingmall.controller.client;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.shoppingmall.domain.TopCategory;
import com.koreait.shoppingmall.model.service.category.TopCategoryService;
import com.koreait.shoppingmall.model.service.product.ProductService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ClientController {
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
	private TopCategoryService topCategoryService;
	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		model.addAttribute("msg", "클라이언트의 요청 테스트");
		return "home";  // 
	}
	
	//클라이언트의 메인 요청 
	@GetMapping("/main")
	public String getMain(Model model) {
		//최상위 카테고리 담아가야 함 
		
		//3단계: 일 시키기 
		List topList = topCategoryService.selectAll();
		
		//4단계: 저장(forwarding)
		model.addAttribute("topList", topList);
		
		return "client/index";
	}
	
	//상품리스트 페이지 요청
	@GetMapping("/shop/list")
	public String getList(Model model , @RequestParam(required=false, defaultValue="0") int subcategory_id) {
		//System.out.println("넘어온 서브 카테고리id는 "+subcategory_id);
		//모든 상품 가져가기, 만일 서브카테고리가 선택된다면, 해당 상품만 가져가기
		List productList=null;
		
		if(subcategory_id==0) {
			//모든 레코드
			productList=productService.selectAll();
		}else{
			//소속 상품만 가져오기
			productList=productService.selectBySubCategory(subcategory_id);
		}
		
		//collection 체크해보기 
		List<TopCategory> topList = topCategoryService.selectChild();
		for(TopCategory topCategory : topList) {
			System.out.println(topCategory.getTop_name()+"가 보유한 수는 "+topCategory.getSubList());
		}
	
		//4단계: 저장(forwarding)
		model.addAttribute("topList", topList);
		model.addAttribute("productList", productList);
		
		return "client/shop/main";
	}
}
