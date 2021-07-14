package com.koreait.springmvc0714.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.koreait.springmvc0714.exception.DMLException;
import com.koreait.springmvc0714.model.board.service.BoardService;
import com.koreait.springmvc0714.model.domain.Board;

import lombok.Setter;

//개시물 등록 요청을 처리할 하위 컨트롤러
@Setter
public class RegistController implements Controller{
	private BoardService boardService;
	
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//3단계 일시키기
		Board board = new Board();
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));
		
		ModelAndView mav = new ModelAndView();
		try {
			boardService.insert(board);//등록
			//성공의 메시지, 페이지 보여주기
			System.out.println("성공");//리스트로 재접속
			mav.setViewName("redirect:/board/list");
		} catch (DMLException e) {
			e.printStackTrace();
			//실패의 에러 페이지 보여주기
			System.out.println("등록시 에러 발생");//에러페이지
			mav.addObject("e",e);//에러 객체 담기
			mav.setViewName("error/result");
		}
		
		//4단계는 저장할게 없으므로 생략, 이때 포워딩 하지 말고, 목록으로 다시 redirect해야함, 즉 지정한 url로 재접속 시켜야함
		return mav;
	}
}
