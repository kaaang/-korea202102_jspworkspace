package site0617.model.gallery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import site0617.model.domain.Gallery;
import site0617.model.pool.PoolManager;

//이 클래스는 오직 gallery에 테이블에 대한 CRUD만을 담당하는 객체이다
public class GalleryDAO {
	PoolManager pool=PoolManager.getInstance();
	
	
	public int insert(Gallery gallery) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		con=pool.getConnection();
		String sql = "insert into gallery(gallery_id, title, writer, content, filename) values(seq_gallery.nextval,?,?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, gallery.getTitle());
			pstmt.setString(2, gallery.getWriter());
			pstmt.setString(3, gallery.getContent());
			pstmt.setString(4, gallery.getFilename());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt);
		}
		return result;
	}
	
	
	
	public List selectAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Gallery> list = new ArrayList<Gallery>();
		
		con = pool.getConnection();		
		String sql="select * from gallery";
		try {
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Gallery gallery = new Gallery();
				gallery.setGallaery_id(rs.getInt("gallery_id"));
				gallery.setTitle(rs.getString("title"));
				gallery.setWriter(rs.getString("writer"));
				gallery.setContent(rs.getString("content"));
				gallery.setRegdate(rs.getString("regdate"));
				gallery.setFilename(rs.getString("filename"));
				gallery.setHit(rs.getInt("hit"));
				list.add(gallery);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt, rs);
		}
		return list;
	}
	
	
	//한건 가져오기
	public void select() {
		
		String sql="select * from gallery where gallery_id=?";
	}
	
	
	
	
	
	
	
}
