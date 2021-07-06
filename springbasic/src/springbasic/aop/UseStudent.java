package springbasic.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseStudent {

	public static void main(String[] args) {
		//스프링 컨테이너 생성
		ApplicationContext context = new ClassPathXmlApplicationContext("springbasic/aop/aop.xml");
		
		//이 시점에 xml에 명시된 bean태그들은 실제 자바 객체로 인스턴스가 생성되어, ApplicationContext의 관리 대상이 됨
		
		Student st = (Student)context.getBean("student");
		st.study1();
		st.study2();
		st.study3();
		st.study4();
		st.study5();
		st.study6();
		
		Soldier s = (Soldier)context.getBean("soldier");
		s.getUp();
		s.eat();
		s.work();
		s.eat2();
		s.sleep();
	}
	
	
}
