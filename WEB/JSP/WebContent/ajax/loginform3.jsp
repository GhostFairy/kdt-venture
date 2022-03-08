<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.6.0.min.js"></script>
<script>
	function requestAjax() {
		$.ajax({
			// 전달할 URL
			url : "loginresult.jsp",
			// 전달 방식
			type : "get",
			// 전달할 데이터
			data : {
				"id" : $("#id").val(),
				"pw" : $("#pw").val()
			},
			// 전달받을 데이터 타입
			dataType : "JSON",
			// 통신 성공시 동작
			success : function (server_response) {
				// json_response = JSON.parse(server_response);
				if ( server_response.login ) {
					$("#here").html("<h3>[" + server_response.time + "] 정상적으로 로그인되었습니다.</h3>");
					$("#here").css("color", "green");
				} else {
					$("#here").html("<h3>로그인에 실패하였습니다.</h3>");
					$("#here").css("color", "red");
				}
			},
			// 통신 실패시 동작
			error : function (err) {
				alert(err);
			}
		});
	}

	function alluserAjax() {
		$.ajax({
			// 전달할 URL
			url : "loginresult3.jsp",
			// 전달 방식
			type : "get",
			// 전달할 데이터
			data : {
				"id" : $("#id").val(),
				"pw" : $("#pw").val()
			},
			// 전달받을 데이터 타입
			dataType : "JSON",
			// 통신 성공시 동작
			success : function(server_response) {
				let out = "<table border=\"3\"><tbody>";
				for (let i = 0; i < server_response.length; i++) {
					out += "<tr><td>" + server_response[i].id + "</td><td>" + server_response[i].name + "</td><td>" + server_response[i].phone + "</td><td>" + server_response[i].email + "</td><td>" + server_response[i].address + "</td></tr>";
				}
				$("#alluserdiv").html(out + "</tbody></table>");
			},
			// 통신 실패시 동작
			error : function(err) {
				alert(err);
			}
		});
	}

	$(document).ready(function() {
		$("#ajaxbtn").on("click", function() {
			requestAjax();
		});
		
		$("#alluserbtn").on("click", function() {
			alluserAjax();
		});
	});
</script>
</head>
<body>
	<h1>로그인</h1>
	<form action="loginresult3.jsp" method="post">
		<label>아이디<br> <input type="text" id="id" name="id"></label><br>
		<label>비밀번호<br> <input type="password" id="pw" name="pw"></label><br>
		<br><input type="button" id="ajaxbtn" value="로그인">
		<input type="button" id="alluserbtn" value="회원 목록">
	</form>
	<div id="here"><br></div>
	<div id="alluserdiv" style="border:2px solid pink; width: 450px; height: 450px; overflow: scroll"></div>
</body>
</html>