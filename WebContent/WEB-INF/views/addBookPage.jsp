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
	<%@include file="adminHeader.jsp"%>
	<br />
	<h2>Add Book</h2>
	<form:form method="post" action="/SpringHibernateIntegration/addBook.html"
		commandName="multiFileUpload" enctype="multipart/form-data">
<%-- 	<form method="POST" action="/SpringHibernateIntegration/addBook.html" enctype="multipart/form-data">--%>
		<table>
			 <tr>
				<td>Book name :</td>
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
				<td>Upload Book :</td>
				<td><input name="multiUploadedFileList[0]" type="file" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>			
		</table>
	</form:form>
</body>
</html>