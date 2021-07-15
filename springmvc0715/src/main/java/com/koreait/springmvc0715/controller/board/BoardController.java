package com.koreait.springmvc0715.controller.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.springmvc0715.model.board.service.BoardService;
import com.koreait.springmvc0715.model.domain.Board;

import lombok.Setter;

//목록, 등록, 수정, 삭제, 상세보기를 하나의 컨트롤러에서 처리

@Setter
@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;//DI로 주입을 요청해야한다
	
	
	//목록 요청을 처리하는 메서드
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public String getList(Model model) {
		List boardList=boardService.selectAll();
		model.addAttribute("boardList",boardList);
		return "board/list";
	}
	
	
	
	//글쓰기 요청 처리
	@RequestMapping(value="/board/regist", method=RequestMethod.POST)
	public String regist(Board board, Model model) {//board VO에 들어있는 멤버변수와 html의 파리미터명이 동일하다면 자동 매핑

		String viewName=null;
		try {
			boardService.insert(board);
			viewName="redirect:/board/list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("e",e);
			viewName="error/result";
		}
		
		//개발자가 String형으로 뷰 이름을 반환하면 내부적으로는 ModelAndView의 setViewName() 작성하는것과 동일
		return viewName;
	}
	
	
	
	//상세보기 요청 처리
	@RequestMapping(value="/board/detail", method=RequestMethod.GET)
	public String getDetail(int board_id, Model model) {
		Board board = boardService.select(board_id);
		model.addAttribute("board",board);
		return "board/detail";
	}
	
	
	//수정 요청 처리
	@RequestMapping(value="/board/update", method=RequestMethod.POST)
	public ModelAndView edit(Board board) {

		ModelAndView mav = new ModelAndView();
		try {
			boardService.update(board);
			mav.setViewName("redirect:/board/detail?board_id="+board.getBoard_id());
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("e",e);
			mav.setViewName("error/result");
		}
		
		
		return mav;
	}
	
	
	@RequestMapping(value="/board/del", method = RequestMethod.POST)
	public String delete(int board_id, Model model) {
		String viewName=null;
		try {
			boardService.delete(board_id);
			viewName="redirect:/board/list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("e",e);
			viewName="error/result";
		}
		
		return viewName;
	}
	
}
