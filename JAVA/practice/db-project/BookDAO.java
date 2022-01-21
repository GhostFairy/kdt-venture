import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {

	public void insertBook(BookDTO bookDTO) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// DB 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");

			// SQL 작성 및 전송
			ps = conn.prepareStatement("INSERT INTO book VALUES(?, ?, ?, ?, ?, ?)");
			ps.setString(1, bookDTO.bookNo);
			ps.setString(2, bookDTO.bookTitle);
			ps.setString(3, bookDTO.bookAuthor);
			ps.setInt(4, bookDTO.bookYear);
			ps.setInt(5, bookDTO.bookPrice);
			ps.setString(6, bookDTO.bookPublisher);
			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 연결 종료
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // insertBook() ends

	public void selectBook() {
		Connection conn = null;
		ResultSet rs = null;
		try {
			// DB 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");

			// SQL 작성 및 전송
			rs = conn.prepareStatement("SELECT * FROM book").executeQuery();

			// 결과 출력
			while (rs.next()) {
				String bookNo = rs.getString("bookNo");
				String bookTitle = rs.getString("bookTitle");
				String bookAuthor = rs.getString("bookAuthor");
				int bookYear = rs.getInt("bookYear");
				int bookPrice = rs.getInt("bookPrice");
				String bookPublisher = rs.getString("bookPublisher");
				System.out.println(bookNo + "\t" + bookTitle + "\t" + bookAuthor + "\t" + bookYear + "\t" + bookPrice + "\t" + bookPublisher);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 연결 종료
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // selectBook() ends

}
