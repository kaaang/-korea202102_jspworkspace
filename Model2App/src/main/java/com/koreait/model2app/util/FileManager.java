package com.koreait.model2app.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.koreait.model2app.model.domain.License;
import com.koreait.model2app.model.domain.Member;

public class FileManager {
	//확장자만 추출하기 , 경로를 넘겨받아 확장자만 추출
		public static String getExt(String path) {
			//test.kkk.jpg 
			return path.substring(path.lastIndexOf(".")+1, path.length());
		}
		
		
		//웹 기반의 파일 업로드
		public static Member saveFile(HttpServletRequest request) {
			//아파치의 파일 업로드를 이용한 파일 저장 및 파라미터 처리를 해야한다 -> 멀티파트
			
			
			DiskFileItemFactory factory=new DiskFileItemFactory();//업로드 설정 객체
			ServletContext context=request.getServletContext();//어플리케이션의 정보를 가진 객체를 얻기 jsp에서의 application내장객체임
			String realPath=context.getRealPath("/data");//실제 물리적 저장 경로 얻기
			factory.setRepository(new File(realPath));
			factory.setSizeThreshold(2*1024*1024);//2M 제한
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			Member member=null;
			
			try {
				List<FileItem> items=upload.parseRequest(request);//요청을 분석하여 업로드 실행
				member=new Member();
				
				for(FileItem item : items) {
					if(item.isFormField()) {//text필드라면
						if(item.getFieldName().equals("name")) {
							member.setName(item.getString("utf-8"));
						}else if(item.getFieldName().equals("phone")) {
							member.setPhone(item.getString("utf-8"));
						}else if(item.getFieldName().equals("addr")) {
							member.setAddr(item.getString("utf-8"));
						}else if(item.getFieldName().equals("title")) {
							License license = new License();
							license.setTitle(item.getString("utf-8"));//자격증 대입
							member.getList().add(license);//Member VO에 자격증 한개 추가
						}
					}else {//파일필드라면
						try {
							String ext=FileManager.getExt(item.getName());//확장자 구하기
							
							String newName=System.currentTimeMillis()+"."+ext;
							item.write(new File(realPath+"/"+newName));//파일저장
							//vo에 저장
							member.setPhoto(newName);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			
			return member;
			
		}
		
		
		
		
		
		
		
		
		
		/*
		public static void main(String[] args) {
			System.out.println(getExt("test.kkk.jpg"));
		}
		*/
}
