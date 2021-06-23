package com.koreait.site0622.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.site0622.model.domain.Member;
import com.koreait.site0622.model.member.dao.MemberDAO;
import com.koreait.site0622.model.member.dao.MybatisMemberDAO;
import com.koreait.site0622.util.message.MessageObject;

//아이디 중복 체크 전용 서블릿
public class CheckIdServlet extends HttpServlet{
	MessageObject messageObject;
	MemberDAO memberDAO;
	@Override
	public void init() throws ServletException {
		memberDAO = new MybatisMemberDAO();
		messageObject = new MessageObject();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 넘겨받아, member테이블에 존재하는지 여부 확인
		String user_id = request.getParameter("user_id");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Member member = memberDAO.getMemberById(user_id);//다형성
		
		
		
		/*
		 * 동기 방식일때 적절한 응답 정보
		if(member==null) {
			//회원가입 진행해도 됨
			out.print(messageObject.getMsgURL("사용 가능한 아이디 입니다.","/member/signup.jsp"));			
		}else {
			//거절해야함
			out.print(messageObject.getMsgBack("이미 사용중인 아이디 입니다."));
		}
		*/
		
		
		
		//비동기에 적절한 응답 보내기
		
		if(member==null) {
			out.print(0);
		}else {
			out.print(1);
		}
		
		
		
		
	}
}
