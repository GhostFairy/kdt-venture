<%@page import="dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0px;
	padding: 0px;
}

table {
	margin: 0 auto;
	border: 5px solid black;
	border-collapse: collapse;
	text-align: center;
}

th, td {
	padding: 20px;
	border: 3px solid black;
}

ul {
	display: table;
	margin: 0 auto;
	text-align: center;
	list-style: none;
}

li {
	float: left;
	margin: auto 10px;
	font-weight: bolder;
}
</style>
</head>
<body>
	<%
	String pageInput = request.getParameter("page");
	int pageNum = 1;
	if (pageInput != null) {
		pageNum = Integer.parseInt(pageInput);
	}
	int userPerPage = 3;
	MemberDAO dao = new MemberDAO();
	ArrayList<MemberDTO> list = dao.selectMember(pageNum, userPerPage);

	out.println("<table><thead><tr>");
	out.println("<th>ID</th><th>이름</th><th>휴대폰번호</th><th>이메일</th><th>주소</th>");
	out.println("</tr></thead><tbody>");
	for (MemberDTO dto : list) {
		out.println("<tr>");
		out.println("<td>" + dto.getId() + "</td>");
		out.println("<td>" + dto.getName() + "</td>");
		out.println("<td>" + dto.getPhone() + "</td>");
		out.println("<td>" + dto.getEmail() + "</td>");
		out.println("<td>" + dto.getAddress() + "</td>");
		out.println("</tr>");
	}
	out.println("</tbody></table><br>");

	int total = dao.getTotalCount();
	int pagesNum = total / userPerPage;
	if (total % userPerPage != 0) {
		pagesNum++;
	}
	out.println("<ul>");
	for (int i = 1; i <= pagesNum; i++) {
		out.println("<li>");
		if (i != pageNum) {
			out.println("<a href='paginguserlist.jsp?page=" + i + "'>[ " + i + " ]</a>");
		} else {
			out.println("[ " + i + " ]");
		}
		out.println("</li>");
	}
	out.println("</ul>");
	%>
</body>
</html>