package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

@WebServlet("/logindb")
public class LoginDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO();

		switch (dao.selectMember(id, pw)) {
		case 0:
			out.append("<h3 style='color:green'>정상 사용자입니다.</h3>");
			break;
		case 1:
			out.append("<h3 style='color:orange'>");
			out.append("입력하신 비밀번호는 맞지 않습니다.<br><br>");
			out.append("<a href='logindbservlet.html'>되돌아가시려면 여기를 클릭하세요.</a>");
			out.append("</h3>");
			break;
		case 2:
			out.append("<h3 style='color:red'>");
			out.append("입력하신 아이디가 없습니다.<br><br>");
			out.append("<a href='insertservlet.html'>가입하시려면 여기를 클릭하세요.</a>");
			out.append("</h3>");
			break;
		default:
			break;
		}
	}

}
