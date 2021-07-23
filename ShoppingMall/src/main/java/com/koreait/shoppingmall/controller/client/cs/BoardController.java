package com.koreait.shoppingmall.controller.client.cs;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import com.koreait.shoppingmall.domain.Board;
import com.koreait.shoppingmall.exception.DMLException;
import com.koreait.shoppingmall.model.service.cs.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/cs/board/main")
	public String boardMain() {
		return "client/board/index";
	}
	
	
	
	
	@PostMapping("/cs/board/regist")
	@ResponseBody //jsp뷰 페이지가 아닌 데이터를 클라이언트에게 전송
	public String regist(@RequestBody String data) {
		System.out.println(data);
		JSONParser jsonParser = new JSONParser();

		try {
			JSONObject json=(JSONObject)jsonParser.parse(data);
			
			System.out.println(json.get("title"));
			System.out.println(json.get("writer"));
			System.out.println(json.get("content"));
			
			Board board = new Board();
			board.setTitle((String)json.get("title"));
			board.setWriter((String)json.get("writer"));
			board.setContent((String)json.get("content"));
			
			boardService.insert(board);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		return "1";
	}
	
	
	//글목록 요청 처리
	@RequestMapping(value = "/cs/board/list",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String getList() {
		List<Board> boardList = boardService.selectAll();
		
		//Gson을 이용하면, 자바 객체를 json으로 변환하는 작업을 직접 할 필요없고, 개발자는 자바코드로 맵을 구성한 후 gson을 호출하면 된다.
		Gson gson = new Gson();
		return gson.toJson(boardList);
	}
	
	
	@ExceptionHandler(DMLException.class)
	@ResponseBody
	public String handleException(DMLException e) {
		return e.getMessage();
	}
	
	
}
