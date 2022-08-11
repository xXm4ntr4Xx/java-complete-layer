<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body>
	
	<form action="http://localhost:8080/customer-management-system/CustomerLoginServlet" method="POST">
	
	
	
	Email  ID : <input type="text" name="customerEmail"/> <br>	
	
	Password : <input type="text" name="customerPassword"/> <br>
	
	<input type="submit" value="Login"/>
	
	
	</form>

   New Customer? <a href="index.jsp"/>

</body>
</html>