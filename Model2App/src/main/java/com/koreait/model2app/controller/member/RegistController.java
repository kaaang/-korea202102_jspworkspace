package com.koreait.model2app.controller.member;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.exception.LicenseRegistException;
import com.koreait.model2app.model.domain.License;
import com.koreait.model2app.model.domain.Member;
import com.koreait.model2app.model.license.dao.JdbcLicenseDAO;
import com.koreait.model2app.model.license.dao.LicenseDAO;
import com.koreait.model2app.model.member.dao.JdbcMemberDAO;
import com.koreait.model2app.model.member.dao.MemberDAO;
import com.koreait.model2app.model.member.service.MemberService;
import com.koreait.model2app.model.member.service.MemberServiceImpl;
import com.koreait.model2app.util.FileManager;

//회원의 등록 요청을 처리하는 하위 컨트롤러
public class RegistController implements Controller{

	MemberService memberService;
	FileManager fileManager;
	String viewName;
	boolean forward;//포워딩 여부를 결정
	
	public RegistController() {
		memberService = new MemberServiceImpl();
	}
	
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		Member member = FileManager.saveFile(request);//파일 업로드
		
		try {
			memberService.regist(member, request);
			viewName="/result/member/regist";
			//리스트로 재접속하게 해야함
			forward=false;
		}catch (LicenseRegistException e) {
			viewName="/result/error";
			//에러 페이지로 결과 메시지를 가져가야함
			forward=true;
			request.setAttribute("obj",e);
		}
		
	}

	public String getViewName() {
		return viewName;
	}

	public boolean isForward() {
		return forward;
	}

}
