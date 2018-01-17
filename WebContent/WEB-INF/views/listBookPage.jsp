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
	<%@include file="adminHeader.jsp"%><br>
	<h1>List of Books</h1>

	<c:if test="${!empty books}">
		<table align="left" border="1">
			<tr>
				<th>Book ID</th>
				<th>Book Name</th>
				<th>Book author</th>
				<th>Book price</th>
				<th>Edit</th>
				<th>Delete</th>
				<th>View</th>
			</tr>

			<c:forEach items="${books}" var="book">
				<tr>
					<td><c:out value="${book.id}" /></td>
					<td><c:out value="${book.name}" /></td>
					<td><c:out value="${book.author}" /></td>
					<td><c:out value="${book.price}" /></td>
					<td><a href="editBookPage.html?id=${book.id}">Edit</a></td>
					<td><a href="deleteBook.html?id=${book.id}">Delete</a></td>
					<td><a href="viewBook.html?id=${book.id}">View</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>