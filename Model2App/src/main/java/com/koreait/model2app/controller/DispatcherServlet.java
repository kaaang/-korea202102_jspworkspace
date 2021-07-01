package com.koreait.model2app.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//웹 클라이언트의 모든 요청을 받는 유일한 진입점 서블릿 (요청을 분석하여 어떤 하위컨트롤러가 요청을 전담할지를 결정짓고,
//해당 하위 컨트롤러가 업부를 마친 후에느 결과를 다시 클라이언트에게 전달 즉 응답을 처리한다.
public class DispatcherServlet extends HttpServlet{
	//아래의 객체들은 적어도 분석하기 전에는 미리 메모리에 올라와 있어야함
	Properties props;//MAP의 자식
	FileReader reader;//프로퍼티스 객체는 자체적으로 파일을 접근할 수 업기 떄문에 파일스트림이 필요함
	
	public void init(ServletConfig config) throws ServletException {
		props=new Properties();
		try {
			//ServletContext(어플리케이션의 전역적 정보를 가진 객체)
			ServletContext context = config.getServletContext();
			
			//유지보수성을 높이려면, 설정 정보 등은 자바 코드 안에 두기보다는 외부 설정 파일에 두어서, 변경하기 쉽게 차리하는 방식이 일반적이다.
			String realPath = context.getRealPath(config.getInitParameter("contextConfigLocation"));
			reader=new FileReader(realPath);
			props.load(reader);//프로퍼티스 객체가 스트림을 이욯아는 시점 즉, 파일을 검색하기 위한 준비물
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//하위 컨트롤러에게 request, response 객체를 전달하기 전에 공통적인 기능이 있으면, 형님쪽에서 처리하자
		request.setCharacterEncoding("utf-8");
		
		//요청 분석(uri 분석)
		String uri=request.getRequestURI();
		
		//if문 대신, props파일을 탐색하기 (Map으로 대체됨)
		//이렇게 매 요청마다 처리할 로직을 전담 객체를 1:1로 부여하는 방식을 가리켜 command pattern이라 한다.
		String className = props.getProperty(uri);
		System.out.println("클래스 명 : "+className);
		
		//클래스 이름을 이용하여, 클래서 Load하기
		Controller controller=null;
		try {
			//파일에 명시된 클래스명을 이용하며, 동적으로 인스턴스를 생성하는 방법 == 팩토리 패턴이라 한다.
			Class controllerClass = Class.forName(className);
			controller=(Controller)controllerClass.newInstance();//인스턴스 생성
			
			//하위 컨트롤러 동작
			controller.excute(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		
		//응답 정보를 이용한 응답처리(즉 결과 보여주기)
		//결과는 MVC중 VIEW가 담당하므로, 현재 파일과는 다른 jsp에서 처리한다.
		//주의)응답을 하면 네트워크가 끊기고 요청 프로세스가 종료되므로, 응답을 하지 않고 원하는 jsp 자원에 포워딩해야한다.
		String viewName=controller.getViewName();
		//넘겨받은 viewName을 이용하여서 다시 mapping파일 검색
		String viewPage = props.getProperty(viewName);
		
		
		if(controller.isForward()) {
			RequestDispatcher dis = request.getRequestDispatcher(viewPage);
			dis.forward(request, response);
		}else {
			response.sendRedirect(viewPage);
		}
		
		
		//다시 재접속을 명령하는 경우 redirect == location.href
		
		
	}
	
	
	
	
	
	//서블릿의 생명주기 메서드 중, 서블릿 소멸시 호출되는 destory() 재정의
	public void destroy() {
		if(reader!=null) {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
