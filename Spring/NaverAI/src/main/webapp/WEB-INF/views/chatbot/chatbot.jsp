<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/jquery-3.6.0.min.js"></script>
<script src="/js/chatbot/chatbot.js"></script>
</head>
<body>
	<h1>챗봇 서비스</h1>
	<div id="chat" style="border: 1px lime solid; width: 500px">
		<audio id="audio" autoplay></audio>
	</div>
	<div>
		<span>질문 입력:</span>
		<input type="text" id="voiceMessage" value="헤이 클로바">
		<input type="button" value="전송" id="send">
	</div>
	<div>
		<span>음성 질문:</span>
		<input type="button" value="녹음 시작" id="record">
		<input type="button" value="녹음 완료" id="stop">
	</div>
</body>
</html>