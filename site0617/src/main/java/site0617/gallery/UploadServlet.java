package site0617.gallery;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import site0617.model.domain.Gallery;
import site0617.model.gallery.dao.GalleryDAO;
import site0617.util.FileManager;

//이미 jsp로도 업로드 처리가 가능하겠으나, 서블리을 다시한번 공부해보고자 이 클래스를 작성하는것임
public class UploadServlet extends HttpServlet{
	
	
	ServletContext context;
	GalleryDAO galleryDAO;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
		galleryDAO = new GalleryDAO();
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("제가 업로드 처리할게요<br>");
		
		
		request.setCharacterEncoding("utf-8");
		
		//요청 파라미터 받기(인코딩되어 전송되므로, 이를 해석(decode)할 컴포넌트가 사용되어야한다
		//아래처럼 경로를 개발자가 직접 구할 경우, 시스템에 의존적이되므로, 이 웹 어플리케이션을 다른 기반의
		//플렛폰에서 배포하여 실행할때 문제가 발생할 수 있다. 
		//해결책 ? 프로그래밍 적으로 경로를 동적으러 얻어와서 처리하면 됨
//		String path = "D:\\korea202102_jspworkspace\\site0617\\src\\main\\webapp\\data";
		String path = context.getRealPath("/data");
		out.print(path);
		
		
		
//		MultipartRequest multi = new MultipartRequest(request, path);//한글깨짐
		int maxSize = 6*1204*1204;
		try {
//			MultipartRequest multi = new MultipartRequest(request, path,maxSize);//업로드 용량제한
			MultipartRequest multi = new MultipartRequest(request, path,maxSize,"utf-8");//인코딩 추가
			out.print("업로드 완료<br>");
			//이미 서버에 업로드된 파일의 이름을 바꾸자!
			File file=multi.getFile("myfile");//이미 업로드 된 파일
			long time = System.currentTimeMillis();
			String destName = time+"."+FileManager.getExt(file.getName());
			File dest = new File(path+"/"+destName);//새로 만들어질 파일
			file.renameTo(dest);
			
			String title = multi.getParameter("title");
			String writer = multi.getParameter("writer");
			String content = multi.getParameter("content");
			//db에 넣기
			Gallery gallery = new Gallery();
			gallery.setTitle(title);
			gallery.setWriter(writer);
			gallery.setContent(content);
			gallery.setFilename(destName);
			
			int result = galleryDAO.insert(gallery);
			if(result==0) {
				out.print("등록 실패<br>");				
			}else {
				out.print("등록 성공<br>");	
				//리스트 요청
				response.sendRedirect("/gallery/list.jsp");//지정한 url로 다시 재접속을 명령(클라이언트에게)
			}
			
			
		} catch (IOException e) {
			out.print("업로드 실패<br>");			
			e.printStackTrace();
		}
		out.print("업로드 완료<br>");
		
		
	}
}
