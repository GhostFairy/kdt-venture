package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.MemberDTO;

// CRUD 구현
public class MemberDAO {

	public int deleteMember(String id) {
		Connection conn = null;
		int result = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");
			
			// DELETE SQL
			PreparedStatement ps = conn.prepareStatement("DELETE FROM member_table WHERE id LIKE ?");
			ps.setString(1, id);
			result = ps.executeUpdate();
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
	} // deleteMember(id) end

	public void updateMember(MemberDTO dto) {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");

			// UPDATE SQL
			PreparedStatement ps = conn.prepareStatement("UPDATE member_table SET password = ?, name = ?, address = ? WHERE id LIKE ?");
			ps.setString(1, dto.getPassword());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getAddress());
			ps.setString(4, dto.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // updateMember(dto) end

	public MemberDTO updateFormMember(String id, String password) {
		Connection conn = null;
		MemberDTO dto = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");

			// SELECT SQL
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM member_table WHERE id LIKE ? AND password LIKE ?");
			ps.setString(1, id);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String queryId = rs.getString("id");
				String queryPassword = rs.getString("password");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String address = rs.getString("address");

				dto = new MemberDTO(queryId, queryPassword, name, phone, email, address);
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

		return dto;
	} // updateFormMember() end

	public int getTotalCount() {
		Connection conn = null;
		int count = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");

			// SELECT SQL
			PreparedStatement ps = conn.prepareStatement("SELECT count(*) FROM member_table");
			ResultSet rs = ps.executeQuery();
			rs.next();
			count = rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return count;
	} // getTotalCount() end

	public ArrayList<MemberDTO> selectMember() {
		Connection conn = null;
		ArrayList<MemberDTO> result = new ArrayList<MemberDTO>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");

			// SELECT SQL
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM member_table");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String address = rs.getString("address");

				MemberDTO dto = new MemberDTO(id, password, name, phone, email, address);
				result.add(dto);
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
	} // selectMember() end

	public ArrayList<MemberDTO> selectMember(int page, int userPerPage) {
		Connection conn = null;
		ArrayList<MemberDTO> result = new ArrayList<MemberDTO>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");

			// SELECT SQL
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM member_table LIMIT ?, ?");
			ps.setInt(1, (page - 1) * userPerPage);
			ps.setInt(2, userPerPage);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String address = rs.getString("address");

				MemberDTO dto = new MemberDTO(id, password, name, phone, email, address);
				result.add(dto);
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
	} // selectMember(page, userPerPage) end

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
