package site0617.model.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class PoolManager {
	InitialContext ctx; //JNDI를 활용한 검색객체
	DataSource ds; 
	
	private static PoolManager instance;
	
	private PoolManager() {
		//ds=톰켓이 지원하는 커넥션풀을 JNDI로 가져오자!
		try {
			ctx = new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/jndi/oracle"); //검색 후 DataSource 반환
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static PoolManager getInstance() {
		if(instance == null) {
			instance = new PoolManager();
		}
		return instance;
	}
	
	//커넥션 얻기
	public Connection getConnection() {
		Connection con=null;
		try {
			con=ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	//Connection만 반환 
	public void release(Connection con) {
		if(con!=null)try {con.close();} catch (SQLException e) {e.printStackTrace();}
	}
	//DML 수행 후 반환
	public void release(Connection con, PreparedStatement pstmt) {
		if(pstmt!=null)try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
		if(con!=null)try {con.close();} catch (SQLException e) {e.printStackTrace();}
	}
	//select 수행 후 반환
	public void release(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if(rs!=null)try {rs.close();} catch (SQLException e) {e.printStackTrace();}
		if(pstmt!=null)try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
		if(con!=null)try {con.close();} catch (SQLException e) {e.printStackTrace();}
	}
}







