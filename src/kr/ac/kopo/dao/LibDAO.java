package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.MemberVO;


public class LibDAO {
	
	public LibDAO() {

	}

	public void insertLibMember(MemberVO member) {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_member(id, password, name, birth, email, phone) ");
		sql.append(" values(?, ?, ?, ?, ?, ? ) ");

		try (Connection conn = new ConnectionFactory().getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getBirth());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getPhone());
			
			pstmt.executeUpdate();
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public boolean equalsID(String id) {
		
		StringBuilder sql = new StringBuilder();
		String id1 = null;
		sql.append("select id from t_member ");
		try ( 
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				ResultSet rs = pstmt.executeQuery();
				){
			while(rs.next()) {
				id1 = rs.getString("id");
				if(id1.equals(id)) {
					return true;
					
				}
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
