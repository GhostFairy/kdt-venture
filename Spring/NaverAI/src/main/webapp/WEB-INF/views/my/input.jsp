<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/jquery-3.6.0.min.js"></script>
</head>
<body>
	<form action="/my" method="post">
		<input type="text" name="q" style="width: 300px;">
		<input type="submit" value="대화하기">
	</form>
</body>
</html>