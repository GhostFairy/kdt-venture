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

	int bookCookieCount;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookTitle = request.getParameter("title");
		Cookie bookCookie = new Cookie("c_bookTitle" + bookCookieCount++, bookTitle);
		response.addCookie(bookCookie);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		out.println("<h1>지금까지 선택하신 도서는 ");
		for (Cookie c : request.getCookies()) {
			if (c.getName().contains("c_bookTitle") && c.getValue() != null) {
				out.println(c.getValue() + ", ");	
			}
		}
		out.println(bookTitle + "입니다.</h1>");
	}

}
