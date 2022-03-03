package cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookcookie")
public class BookCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookTitle = request.getParameter("title");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		boolean isBookTitleCookieExists = false;
		out.println("<h1>지금까지 선택하신 도서는 ");
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("bookTitle")) {
				isBookTitleCookieExists = true;
				if (bookTitle != null) {
					// 쿠키가 있음 + 입력값이 있음: 기존 쿠키에 입력값을 더해 출력
					cookie.setValue(cookie.getValue() + "-" + bookTitle);
					response.addCookie(cookie);
				}
				// 쿠키가 있음 + 입력값이 없음: 기존 쿠키 내용을 출력
				out.println(cookie.getValue() + "입니다.</h1>");
				break;
			}
		}
		if (!isBookTitleCookieExists) {
			if (bookTitle != null) {
				// 쿠키가 없음 + 입력값이 있음: 새 쿠키에 입력값을 넣어 출력
				Cookie bookTitleCookie = new Cookie("bookTitle", bookTitle);
				response.addCookie(bookTitleCookie);
				out.println(bookTitleCookie.getValue() + "입니다.</h1>");
			} else {
				// 쿠키가 없음 + 입력값이 없음: 없습니다 출력
				out.println("없습니다.</h1>");
			}
		}
	}

}
