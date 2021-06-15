
//서블릿이란, javaEE기반의 ㅔ서버에서 실행될 수 있는 클래스이다.. 하지만 서블릿만으로는 개발시 디자인 처리에 너무 많은 리소스가 소모됨
//즉 효율적이지 못하다 왜? 클라이언트에게 전달할 컨텐츠 문자열을 문자열 처리하여 전송해야 하므로.. 즉 디자인에 취약한다.

package servlet.board;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ListServlet extends HttpServlet{
	//요청 처리 메서드
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			//드라이버로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","webmaster","1234");
			if(con!=null){
				out.print("connection ok <br>");
				String sql = "select * from board order by board_id desc";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				//rs를 html 표 table로 출력
				out.print("<table width='100%' border='1px'>");

				out.print("<tr>");
				out.print("<th>No</th>");
				out.print("<th>title</th>");
				out.print("<th>writer</th>");
				out.print("<th>regdate</th>");
				out.print("<th>hit</th>");
				out.print("</tr>");

				

				//반복문으로 tr처리
				while(rs.next()){
					out.print("<tr>");
					out.print("<td>"+rs.getString("title")+"</td>");
					out.print("<td>"+rs.getString("writer")+"</td>");
					out.print("<td>"+rs.getString("regdate")+"</td>");
					out.print("<td>"+rs.getInt("hit")+"</td>");
					out.print("</tr>");
				}
				out.print("</table>");
				
			}else{
				out.print("connection fail <br>");
			}
			//쿼리실행
			
			//접속해제
		}catch(ClassNotFoundException e){//java.lang에 있기 때문에 import할 필요가 없다.
			e.printStackTrace();//스택 에러가 출력되는곳은? 서버의 콘솔창 또는 log파일
		}catch(SQLException e){//java.lang에 있기 때문에 import할 필요가 없다.
			e.printStackTrace();//스택 에러가 출력되는곳은? 서버의 콘솔창 또는 log파일
		}finally{
			if(rs!=null){
				try{rs.close();}catch(SQLException e){}
			}
			if(pstmt!=null){
				try{pstmt.close();}catch(SQLException e){}
			}
			if(con!=null){
				try{con.close();}catch(SQLException e){}
			}
		}
	}
}
