<%@page import="com.jeetkhatri.model.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="userHeader.jsp"%>
    
	<%
		Users user = (Users) session.getAttribute("user");
	%>
	<h2 align="center">Hello <%=user.getName().toUpperCase()%>, Welcome to Users Home page</h2>
</body>
</html>