<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String result = "";
	if (id.equals("ajax") && pw.equals("ajax")) {
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		result = "{ \"login\" : true, \"time\" : \"" + time + "\" }";
	} else {
		result = "{ \"login\" : false }";
	}
%>
<%=result%>