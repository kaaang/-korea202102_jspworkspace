package com.koreait.model2app.model.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koreait.model2app.model.domain.Member;
import com.koreait.model2app.util.pool.PoolManager;

import lombok.Data;

@Data
public class JdbcMemberDAO implements MemberDAO{
	private Connection con;
	
	
	public int insert(Member member) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		
		
		String sql="insert into member(member_id,name, phone, addr, photo) "
				+ "values(seq_member.nextval,?,?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getAddr());
			pstmt.setString(4, member.getPhoto());
			result = pstmt.executeUpdate();
			
			
			if(result!=0) {
				//현재의 세션이 닫히기 전에 언릉, insert에 의해 증가된 sequence값을 얻어오자
				sql="select seq_member.currval as member_id from dual";//dual : 하나만 가지고 있는 더미
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				if(rs.next()) {//레코드가 있다면
					result=rs.getInt("member_id");
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return result;
	}

	public List selectAll() {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Member> list = new ArrayList<Member>();
		
		try {
			pstmt=con.prepareStatement("select * from member");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Member member = new Member();
				member.setMember_id(rs.getInt("member_id"));
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
				member.setAddr(rs.getString("addr"));
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public Member select(int member_id) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member member=null;
		
		try {
			pstmt=con.prepareStatement("select * from member where member_id=?");
			rs=pstmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setMember_id(rs.getInt("member_id"));
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
				member.setAddr(rs.getString("addr"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return member;
	}

	public int update(Member member) {
		return 0;
	}

	public int delete(int member_id) {
		return 0;
	}

}
