package com.koreait.site0625.model.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//mybatis의 설정 xml파일을 읽어들이는 클래스
public class MybatisConfigManager {
	SqlSessionFactory sqlSessionFactory;
	private static MybatisConfigManager instance;
	
	
	






	private MybatisConfigManager() {
		//mybatis의 설정 파일의 위치
		//xml은 .java 즉 클래스가 아니다. 따라서 패키지에 들어있는 xml은 일반 리소스로 취급하자.
		//따라서 접근 경로는 일반 디렉토리 취급하면 된다.
		String resource = "com/koreait/site0625/model/mybatis/config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			
			//SqlSession 객체로 개발자는 쿼리문을 수행할 수 있고, 이 SqlSession객체를 모아놓은 객체를 SqlSessionFactory라한다.
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//new할 수 없고 오직 아래의 getInstance메서드를 통해서만 가져갈 수 있도록 제한
	public static MybatisConfigManager getInstance() {
		if(instance==null) {
			instance = new MybatisConfigManager();
		}
		return instance;
	}

	
	
	
	
	//쿼리 수행용 SqlSession을 반환받아갈 수 있는 메서드 정의
	public SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
	
	//다 사용된 SqlSession 반납
	public void closeSession(SqlSession sqlSession) {
		sqlSession.close();
	}
	
}
