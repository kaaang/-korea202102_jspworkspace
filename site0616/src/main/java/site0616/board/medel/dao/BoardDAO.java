package site0616.board.medel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import site0616.medel.domain.Board;
import site0616.medel.pool.PoolManager;

//웹이건 응용이건 모두 공통적으로 재사용 가능한 수준의 데이터 엑세스 객체를 정의해본다.
//일반적인 어플리케이션 설계 분야에서 이러한 역한(Database와 연동되어 CRUD만을 수행)을 수행하는 객체를 가리켜 DAO라고 한다.
//DAO - Data Access Object
public class BoardDAO {
	
	PoolManager poolManager=PoolManager.getInstance();//싱글턴으로 선언된 PoolManager의 인스턴스 얻기
	
	
	//CRUD메서드 정의
	
	//글쓰기 (글 한건 등록)
	public int insert(Board board) {
		Connection con = null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			con=poolManager.getConnection();//풀로부터 Connection 한개 대여
			String sql="insert into board(board_id, title, writer, content) values(seq_board.nextval,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			
			//쿼리실행
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			poolManager.release(con, pstmt);
			
		}
		return result;
	}
	
	//모든 레코드 가져오기
	public List selectAll() {
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Board> list = new ArrayList<Board>();
		try {
			con=poolManager.getConnection();//풀로부터 Connection 한개 대여
			String sql="select * from board order by board_id desc";
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//곧 죽을 rs를 대신할 리스트에 레코드 한건마다 VO를 담아두고 list에 누적시키자
			while(rs.next()) {
				Board board = new Board();
				board.setBoard_id(rs.getInt("board_id"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getString("regdate"));
				board.setHit(rs.getInt("hit"));
				list.add(board);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			poolManager.release(con, pstmt, rs);
			
		}
		
		return list;
	}
	
	
	
	//레코드 한건 가져오기
	public Board select(int board_id) {
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Board board=null;
		
		try {
			con=poolManager.getConnection();//풀로부터 Connection 한개 대여
			String sql="select * from board where board_id="+board_id;
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new Board();
				board.setBoard_id(rs.getInt("board_id"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getString("regdate"));
				board.setHit(rs.getInt("hit"));				
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			poolManager.release(con, pstmt, rs);
			
		}
		return board;
	}
	
	
	
	//수정
	public int edit(Board board) {
		Connection con = null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			con=poolManager.getConnection();//풀로부터 Connection 한개 대여
			String sql="update board set title=?,writer=?,content=? where board_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.setInt(4, board.getBoard_id());
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			poolManager.release(con, pstmt);
			
		}
		
		return result;
		
	}
	
	
	//수정
	public int del(int board_id) {
		Connection con = null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			con=poolManager.getConnection();//풀로부터 Connection 한개 대여
			String sql="delete from board where board_id="+board_id;
			pstmt=con.prepareStatement(sql);
			
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			poolManager.release(con, pstmt);
			
		}
		
		return result;
		
	}
	
	
	
	
}
