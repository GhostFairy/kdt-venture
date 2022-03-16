<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>정보수정 폼</h1>
<form action="membermybatisupdate" method="post">
	<label>아이디 <input type="text" name="id" value="${ param.id }" readonly></label><br>
	<label>이름 <input type="text" name="name"></label><br>
	<label>주소 <input type="text" name="address"></label><br>
	<input type="submit" value="정보수정">
</form>
</body>
</html>