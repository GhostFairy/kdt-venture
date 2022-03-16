<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${ result eq 1 }">
		<h1>정상적으로 수정되었습니다.</h1>
		<h3><a href="membermybatislist">회원 목록 확인</a></h3>
	</c:if>
</body>
</html>