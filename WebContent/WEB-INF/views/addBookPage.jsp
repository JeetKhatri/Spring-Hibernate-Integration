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
<br/>
	<h2>Add Book</h2>
		<form method="POST" action="/SpringHibernateIntegration/addBook.html">
	   		<table>
			    <tr>
			        <td>Book name : </td>
			        <td><input type="text" name="name" /></td>
			    </tr>
			    <tr>
			        <td>Book author :</td>
			        <td><input type="text" name="author" /></td>
			    </tr>
			    <tr>
			        <td>Book price :</td>
			        <td><input type="number" name="price" /></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form>
</body>
</html>