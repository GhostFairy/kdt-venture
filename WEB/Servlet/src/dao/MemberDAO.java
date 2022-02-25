package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.MemberDTO;

// CRUD 구현
public class MemberDAO {

	public int selectMember(String id, String password) {
		Connection conn = null;
		int result = -1;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");

			// SELECT SQL
			PreparedStatement ps = conn.prepareStatement("SELECT id, password FROM member_table WHERE id LIKE ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			// 조회 성공 = 0, 비밀번호 틀림 = 1, 아이디 없음 = 2
			if (rs.next()) {
				String queryPassword = rs.getString("password");
				if (password.equals(queryPassword)) {
					result = 0;
				} else {
					result = 1;
				}
			} else {
				result = 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	} // selectMember(id, pw) end

	public void insertMember(MemberDTO dto) {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");

			// INSERT SQL
			PreparedStatement ps = conn.prepareStatement("INSERT INTO member_table VALUES(?, ?, ?, ?, ?, ?)");
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPassword());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getPhone());
			ps.setString(5, dto.getEmail());
			ps.setString(6, dto.getAddress());
			int result = ps.executeUpdate();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // insertMember(dto) end

}
