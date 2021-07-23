package com.koreait.shoppingmall.model.common.file;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.shoppingmall.exception.FileHandleException;
import com.koreait.shoppingmall.exception.UploadException;

//비지니스 파트에서 파일과 관련되 업무를 전담하는 객체
@Component
public class FileManager {
	String savePath="/resources/data/";
	
	
	//확장자 구하기
	public String getExt(String path) {
		int lastIndex=path.lastIndexOf(".");
		
		return path.substring(lastIndex+1,path.length());
	}
	
	//파일삭제
	public void deleteFile(ServletContext context,String filename) throws FileHandleException{
		File file=new File(context.getRealPath(savePath+filename));
		boolean result=file.delete();
		if(!result) {
			throw new FileHandleException(filename+"을 삭제하지 못했습니다.");
		}
	}
	
	
	//지정된 경로로 파일 저장
	public void saveFile(ServletContext context,String filename, MultipartFile multi) throws UploadException{
		System.out.println(context.getRealPath(savePath));
		try {
			multi.transferTo(new File(context.getRealPath(savePath)+filename));
		} catch (IllegalStateException e) {
			e.printStackTrace();
			throw new UploadException("업로드 실패",e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new UploadException("업로드 실패",e);
		}
	}
	
	
	
}
