<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<br />
	<h2>Add User</h2>
	<form:form method="post" action="/SpringHibernateIntegration/addUser.html">
		<table>
			 <tr>
				<td>User name :</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>User Email :</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Book password :</td>
				<td><input type="password" name="password" /></td>
			</tr> 
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>			
		</table>
	</form:form>
</body>
</html>