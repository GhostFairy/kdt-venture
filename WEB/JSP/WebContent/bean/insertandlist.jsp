<%@page import="dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<jsp:useBean id="dto" class="dto.MemberDTO" />
	<jsp:setProperty property="*" name="dto" />
	<jsp:useBean id="dao" class="dao.MemberDAO" />
	<%
		dao.insertMember(dto);
		ArrayList<MemberDTO> list = dao.selectMember();
		request.setAttribute("userlist", list);
	%>
	<jsp:forward page="userlist.jsp" />
</body>
</html>