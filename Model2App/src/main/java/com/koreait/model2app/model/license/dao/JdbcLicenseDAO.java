package com.koreait.model2app.model.license.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.koreait.model2app.exception.LicenseRegistException;
import com.koreait.model2app.model.domain.License;
import com.koreait.model2app.util.pool.PoolManager;

import lombok.Data;

@Data
public class JdbcLicenseDAO implements LicenseDAO{
	private Connection con;
	
	public int insert(License license) throws LicenseRegistException{
		PreparedStatement pstmt=null;
		int result=0;
		
		
		String sql="insert into license(license_id, member_id, title) values(seq_license.nextval,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, license.getMember_id());
			pstmt.setString(2, license.getTitle());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			//앞의 인수는 개발자가 원한느 메시지, 뒤의 인수는 에러원인
			throw new LicenseRegistException("라이센스 등록에 실패하였습니다.", e);
		}finally {
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
		return null;
	}

	public License select(int license_id) {
		return null;
	}

	public int update(License license) {
		return 0;
	}

	public int delete(int license_id) {
		return 0;
	}

}
