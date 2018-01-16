<%@page import="com.jeetkhatri.model.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Users user = (Users) session.getAttribute("user");
		if (user.getIsAdmin().equalsIgnoreCase("Y")) {
	%>
	<%@include file="adminHeader.jsp"%>
	<%
		} else {
	%>
	<%@include file="userHeader.jsp"%>
	<%
		}
	%>
	<br />
	<h2>search Book</h2>
	<form method="POST"
		action="/SpringHibernateIntegration/searchBook.html">
		<table>
			<tr>
				<td>Book name :</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
	<br>
	<br>
	<c:if test="${!empty books}">
		<h3>Book List</h3>
		<table align="left" border="1">
			<tr>
				<th>Book ID</th>
				<th>Book Name</th>
				<th>Book author</th>
				<th>Book price</th>
			</tr>
			<c:forEach items="${books}" var="book">
				<tr>
					<td><c:out value="${book.id}" /></td>
					<td><c:out value="${book.name}" /></td>
					<td><c:out value="${book.author}" /></td>
					<td><c:out value="${book.price}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>