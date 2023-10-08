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
    <% boolean authenticated = (sessione.getAttribute("authenticated") != null && (boolean) sessione.getAttribute("authenticated")); %>
	<% if(authenticated) { %>
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
			<li><a href="#" onclick="openOverlay('login-overlay', 'login.jsp')">Login</a></li>
			<li><a href="#" onclick="openOverlay('register-overlay', 'register.jsp')">Register</a></li>
     	    <li><a href="contact.jsp">Assistenza<br></a></li>
	        </ul>
	    </div>
	<% } %>
	
</body>
</html>