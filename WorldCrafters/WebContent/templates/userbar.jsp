<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles/userbar.css">
    <script src="scripts/sidebar-userbar.js"></script>
    <script src="scripts/log-reg.js"></script>
</head>
<body>
	
    <% HttpSession sessione = request.getSession();%>
    <% if(sessione.getAttribute("userId")!=null) { %>
	    <% int userId = (int) sessione.getAttribute("userId");%>
    	<div id="userbar">
	        <ul>
	            <li><a href="purchases">Ordini effettuati<br></a></li>
	            <li><a href="contact.jsp">Assistenza<br></a></li>
	            <li><a href="logout">Logout<br></a></li>
	        </ul>
	    </div>
	<% } else { %>
    	<div id="userbar">
	        <ul>
	            <li><a href="login.jsp">Sign in</a></li>
	            <li><a href="register.jsp">Register</a></li>
	            <li><a href="contact.jsp">Assistenza<br></a></li>
	        </ul>
	    </div>
	<% } %>
	
</body>
</html>