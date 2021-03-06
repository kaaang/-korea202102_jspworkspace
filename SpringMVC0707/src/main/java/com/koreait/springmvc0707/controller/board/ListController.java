package com.koreait.springmvc0707.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvc0707.model.board.service.BoardService;

import lombok.Setter;


@Setter
public class ListController implements Controller{
	
	
	//스프링으로부터 주입 받자
	private BoardService boardService;
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//3단계 : 일시키기
		List boardList = boardService.selectAll();
		System.out.println("결과 : "+boardList);
		
		
		//4단계 저장
		//request.setAttribute("boardList", boardList);
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList",boardList);
		mav.setViewName("board/list");//해석자가 이 부분을 넘겨받아서 실제 jsp로 해석한다.
		
		
		
		return mav;
	}

}
