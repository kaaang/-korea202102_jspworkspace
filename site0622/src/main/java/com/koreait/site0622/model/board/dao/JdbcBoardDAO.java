package com.koreait.site0622.model.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koreait.site0622.model.domain.Board;
import com.koreait.site0622.util.pool.PoolManager;



public class JdbcBoardDAO implements BoardDAO{
	PoolManager pool = PoolManager.getInstance();
	
	//insert
	public int insert(Board board) {
		Connection con = null;
		PreparedStatement pstmt=null;
		int result=0;
		
		con=pool.getConnection();
		try {
			String sql="insert into board(title, writer, content) values(?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt);
		}
		
		return result;
		
	}
	
	
	
	//목록
	public List selectAll() {
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Board> list = new ArrayList<Board>();
		try {
			con=pool.getConnection();//풀로부터 Connection 한개 대여
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
			pool.release(con, pstmt, rs);
			
		}
		
		return list;
		
	}
	
	
	//한건 가져오기
	public Board select(int board_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board board=null;
		
		con=pool.getConnection();
		
		try {
			String sql="select * from board where board_id="+board_id;
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
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
			pool.release(con, pstmt, rs);
		}
		
		return board;
	}
	
	
	//수정하기
	public int update(Board board) {
		Connection con = null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			con=pool.getConnection();//풀로부터 Connection 한개 대여
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
			pool.release(con, pstmt);
			
		}
		
		return result;
	}
	
	
	
	//삭제하기
	public int delete(int board_id) {
		Connection con = null;
		PreparedStatement pstmt=null;
		int result=0;
		
		try {
			con=pool.getConnection();//풀로부터 Connection 한개 대여
			String sql="delete from board where board_id="+board_id;
			pstmt=con.prepareStatement(sql);
			
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt);
			
		}
		
		return result;
	}
	
	
}
