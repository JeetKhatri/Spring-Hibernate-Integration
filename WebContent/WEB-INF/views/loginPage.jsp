<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h2>Add Employee Data</h2>
		<form method="POST" action="/SpringHibernateIntegration/login.html">
	   		<table>
			    <tr>
			        <td>Email</td>
			        <td><input type="text" name="email" /></td>
			    </tr>
			    <tr>
			        <td>Password</td>
			        <td><input type="password" name="password" /></td>
			    </tr>
			   
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form>
</body>
</html>