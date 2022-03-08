<%@page import="java.util.ArrayList"%>
<%@page import="dao.MemberDAO"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="dto.MemberDTO"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	JSONArray jsonArr = new JSONArray();
	if (id.equals("ajax") && pw.equals("ajax")) {
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> list = dao.selectMember();
		for (MemberDTO dto : list) {
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("id", dto.getId());
			jsonObj.put("name", dto.getName());
			jsonObj.put("phone", dto.getPhone());
			jsonObj.put("email", dto.getEmail());
			jsonObj.put("address", dto.getAddress());
			jsonArr.add(jsonObj);
		}
	}
%>

<%= jsonArr.toString() %>