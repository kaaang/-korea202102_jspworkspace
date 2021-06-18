package site0617.util;

public class FileManager {

	//확장자만 추출하기,경로를 넘겨받아 확장자만 추출
	public static String getExt(String path) {
		
		return path.substring(path.lastIndexOf(".")+1,path.length());
		
	}
	
	
	
}
