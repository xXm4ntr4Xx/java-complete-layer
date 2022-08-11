<%@page import="java.util.List"%>
<%@page import="com.ab.models.Customer"%>
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Registered Customers</title>
</head>
<body>
	
	<h1> List of Registered Customers </h1>
	
	
	<% // Scriptlet Tag
	   	// We can write any Java code
	   	
	   	
	   	List<Customer> customerList = (List<Customer>)session.getAttribute("cList");
	
		//out.println(customerList);
		
	%>
	
	
	
	<table border="1">
	
	
		<tr>
		
			<th> Customer ID </th>
			<th> Customer First Name </th>
			<th> Customer Last Name  </th>
			<th> Customer Email </th>
			
		</tr>
	
	<%
	  for(Customer c : customerList){
		  
	 %> 
		<tr>
			
			<td> <%=c.getCustomerId()%> </td>
			<td> <%=c.getFirstName()%> </td>
			<td> <%=c.getLastName()%> </td>
			<td> <%=c.getCustomerEmail()%> </td>
		</tr>		
	
	
	<%
	
	  } // End of for loop
	%>
	
	</table>
	
	
	
	<a href="dashboard.jsp"> Go back </a>
	
	
	
	<table border="1">
	
		<tr>
		
			<th> Customer ID </th>
			<th> Customer First Name </th>
			<th> Customer Last Name  </th>
			<th> Customer Email </th>
			
		</tr>
	
	<c:forEach items="${cList}" var="c">
        <tr>
          <td><c:out value="${c.customerId}" /></td>
          <td><c:out value="${c.firstName}" /></td>
          <td><c:out value="${c.lastName}" /></td>
          <td><c:out value="${c.customerEmail}" /></td>
        </tr>
      </c:forEach>
	
	</table>
	
</body>
</html>