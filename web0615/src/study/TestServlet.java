package study;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;


public class TestServlet extends HttpServlet{
	//��û�� ���� ������ ó���غ��� -> ��service() �޼��尡 ��û �� ������ ó��
	//���� ��û�� ���� �������� �� ��Ʈ���� ���� ���䰴ü�� �Ű������� �Ѱܹ޴´�.
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//��Ʈ���� �̱� ���� �̸� ���ڵ� ó�� ����
		response.setContentType("text/html");//mimetype����
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();//���� ����� ��½�Ʈ���� ��ȯ�ϴ� �޼���
		out.print("this is my second Sevlet !!");
	}
}
