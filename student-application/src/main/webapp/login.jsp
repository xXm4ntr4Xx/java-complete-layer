<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<form action="http://localhost:8080/student-application/StudentLogin" method="POST">
	
	
	
	Email  ID : <input type="text" name="email"/> <br>	
	
	Password : <input type="text" name="password"/> <br>
	
	<input type="submit" value="Login"/>
	
	
	</form>

    <a href="index.jsp">New Customer?</a>
</body>
</html>