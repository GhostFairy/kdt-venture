<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${ name }
		<c:if test="${ !empty param.page }">
		- ${ param.page }페이지
		</c:if>
		<c:if test="${ !empty paramValues.address }">
		-
		<c:forEach var="addr" items="${ paramValues.address }">
		${ addr }
		</c:forEach>
		</c:if>
	</h1>
	<c:forEach var="member" items="${ memberlist }">
		<h3>${ member.id } : ${ member.name } : ${ member.email }</h3>
	</c:forEach>
	<c:forEach var="id" items="${ membersearchlist }">
		<h3>${ id }</h3>
	</c:forEach>
</body>
</html>