<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="adminHeader.jsp"%>

	<h2 align="center">Admin Home page</h2>
	<br>
	<br>
	<br>
	<br>
	<%
		String msg = (String) request.getAttribute("msg");
		if (msg != null) {
			out.println(msg);
		}
	%>
</body>
</html>