<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입 폼</h1>
<form action="membermybatisinsert" method="post">
	<label>아이디 <input type="text" name="id"></label><br>
	<label>비밀번호 <input type="password" name="password"></label><br>
	<label>이름 <input type="text" name="name"></label><br>
	<label>휴대폰번호 <input type="text" name="phone"></label><br>
	<label>이메일 <input type="text" name="email"></label><br>
	<label>주소 <input type="text" name="address"></label><br>
	<input type="submit" value="회원가입">
</form>
</body>
</html>