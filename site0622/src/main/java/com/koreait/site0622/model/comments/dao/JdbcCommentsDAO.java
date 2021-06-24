package com.koreait.site0622.model.comments.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koreait.site0622.model.domain.Comments;
import com.koreait.site0622.util.pool.PoolManager;

public class JdbcCommentsDAO implements CommentsDAO{
	
	
	PoolManager pool=PoolManager.getInstance();
	
	
	
	
	

	public int insert(Comments comments) {
		Connection con = null;
		PreparedStatement pstmt=null;
		con=pool.getConnection();
		int result=0;
		
		String sql="insert into comments(msg, cwriter, news_id) values(?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, comments.getMsg());
			pstmt.setString(2, comments.getCwriter());
			pstmt.setInt(3, comments.getNews_id());
			result=pstmt.executeUpdate();//쿼리수행
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt);
		}
		return result;
	}
	
	
	
	

	public List selectAll() {
		return null;
	}

	public Comments select(int comments_id) {
		return null;
	}

	public int update(Comments comments) {
		return 0;
	}

	public int delete(int comments_id) {
		return 0;
	}
	
	public List selectByNewsId(int news_id) {
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		ArrayList list = new ArrayList();
		
		con=pool.getConnection();
		String sql="select * from comments where news_id=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, news_id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Comments comments = new Comments();
				comments.setComments_id(rs.getInt("comments_id"));
				comments.setMsg(rs.getString("msg"));
				comments.setCwriter(rs.getString("cwriter"));
				comments.setCdate(rs.getString("cdate"));
				comments.setNews_id(rs.getInt("news_id"));
				
				list.add(comments);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt, rs);
		}
		
		return list;
	}

}
