package com.koreait.shoppingmall.model.common.file;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.shoppingmall.exception.UploadException;

//비지니스 파트에서 파일과 관련되 업무를 전담하는 객체
@Component
public class FileManager {
	
	
	//확장자 구하기
	public String getExt(String path) {
		int lastIndex=path.lastIndexOf(".");
		
		return path.substring(lastIndex+1,path.length());
	}
	
	
	//지정된 경로로 파일 저장
	public void saveFile(String path, MultipartFile multi) throws UploadException{
		try {
			multi.transferTo(new File(path));
		} catch (IllegalStateException e) {
			e.printStackTrace();
			throw new UploadException("업로드 실패",e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new UploadException("업로드 실패",e);
		}
	}
	
	
	
}
