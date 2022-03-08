<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- POST 방식으로 전달된 request의 값을 읽을 때 UTF-8로 읽도록 설정 -->
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% boolean result = request.getParameter("age").matches("^\\d+$"); %>
	<c:if test="${ !empty param.name && !empty param.age }">
		<c:if test="<%= result %>">
			<c:choose>
				<c:when test="${ 0 <= param.age && param.age <= 15 }">
					<h3>이름 : ${ param.name }, 가격 : 10000원입니다.</h3>
				</c:when>
				<c:when test="${ 16 <= param.age && param.age <= 19 }">
					<h3>이름 : ${ param.name }, 가격 : 15000원입니다.</h3>
				</c:when>
				<c:when test="${ 20 <= param.age }">
					<h3>이름 : ${ param.name }, 가격 : 20000원입니다.</h3>
				</c:when>
				<c:otherwise>
					<h3>계산할 수 없습니다.</h3>
				</c:otherwise>
			</c:choose>
		</c:if>
		<c:if test="<%= !result %>">
			<h3>계산할 수 없습니다.</h3>
		</c:if>
	</c:if>
	<c:if test="${ empty param.name }">
		<h3>이름을 확인할 수 없습니다.</h3>
	</c:if>
	<c:if test="${ empty param.age }">
		<h3>나이를 확인할 수 없습니다.</h3>
	</c:if>
	
	<c:forEach items="${ paramValues.movie }" var="m">
		<h3>${ m }</h3>
	</c:forEach>
</body>
</html>