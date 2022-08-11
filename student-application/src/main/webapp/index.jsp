<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Main Page</h1>
	<form action="http://localhost:8080/student-application/StudentRegistration" method="POST">
		<label>Name:</label> <input type="text" name="name"/><br/>
		<label>Surname:</label> <input type="text" name="surname"/><br/>
		<label>Email:</label> <input type="email" name="email"/><br/>
		<label>Password:</label> <input type="password" name="password"/><br/>
		<input type="submit" name="Submit"/>
	</form>
	
	<br>
	 <a href="login.jsp">Login</a>
</body>
</html>