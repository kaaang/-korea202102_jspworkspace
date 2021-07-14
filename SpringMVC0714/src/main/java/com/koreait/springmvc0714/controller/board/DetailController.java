package com.koreait.springmvc0714.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvc0714.model.board.service.BoardService;
import com.koreait.springmvc0714.model.domain.Board;

import lombok.Setter;

@Setter
public class DetailController implements Controller{
	private BoardService boardService;

	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//3단계
		int board_id=Integer.parseInt(request.getParameter("board_id"));
		Board board=boardService.select(board_id);
		//4단계
		ModelAndView mav = new ModelAndView("board/detail");
		mav.addObject("board",board);
		
		return mav;
	}
	
	
}
