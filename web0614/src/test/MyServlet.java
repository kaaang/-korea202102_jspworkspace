package test;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
//jsp���̵�, �� �������� ����� ������ �� �ְ�, �Ʒ��� ���� �������� �ؼ� �� ����Ǵ� Ŭ������ ī���� ����(Servlet)�� �ϸ�
//javaEE -- 


//������ �����ֱ� �޼���� �Ҹ��� �ֿ� �޼��尡 �����ϸ�, �� �����ֱ� �޼���� �ϳ��� ���� ��ü�� �¾�� ���ϸ�, �Ҹ��ϴ� ������ ������ �ֿ� �޼��� �̴�.

//���� Ŭ������ ��ġ�� WEB-INF/classes�̹Ƿ�, �� �������� url�� ���� ȣ���� �� ����, ����(mapping)�� �̿��Ѵ�.
public class MyServlet extends HttpServlet{
	//���� �ν��Ͻ��� �¾ ��, ������ �ʱ�ȭ �۾��� ȣ��Ǵ� �޼���
	public void init(){
		System.out.println("Hello, i'm reset complite");
	}
	//�ʱ�ȭ�� �Ϸ��� ������, �� Ŭ���̾�Ʈ�� ��û�� ó���Ҷ� �����ϴ� �޼���
	public void service(HttpServletRequest request, HttpServletResponse response){
		System.out.println("Client request....");

		//�� �������� ���������� �����Ͽ� �����ϱ�
		try{
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();//Ŭ���̾�Ʈ�� ����� ��½�Ʈ��
			out.print("my servlet test is successful!!");
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}
	//������ �Ҹ��Ҷ� ȣ��Ǵ� �޼���
	public void destory(){
		System.out.println("Bye...");
	}
}